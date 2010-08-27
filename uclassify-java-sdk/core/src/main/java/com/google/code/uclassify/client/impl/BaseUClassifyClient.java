/**
 *
 */
package com.google.code.uclassify.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.google.code.uclassify.client.SchemaElementFactory;
import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyConsumer;
import com.google.code.uclassify.client.UClassifyException;
import com.google.code.uclassify.client.util.ApplicationConstants;
import com.google.code.uclassify.client.util.Base64;
import com.google.code.uclassify.client.util.IdGenerator;
import com.google.code.uclassify.client.util.UClassifyUrls;
import com.google.code.uclassify.client.util.UClassifyUrls.UClassifyUrlBuilder;
import com.uclassify.api._1.requestschema.AddClass;
import com.uclassify.api._1.requestschema.Classify;
import com.uclassify.api._1.requestschema.Create;
import com.uclassify.api._1.requestschema.GetInformation;
import com.uclassify.api._1.requestschema.Remove;
import com.uclassify.api._1.requestschema.RemoveClass;
import com.uclassify.api._1.requestschema.TextBase64;
import com.uclassify.api._1.requestschema.TextList;
import com.uclassify.api._1.requestschema.Train;
import com.uclassify.api._1.requestschema.Uclassify;
import com.uclassify.api._1.requestschema.Untrain;
import com.uclassify.api._1.requestschema.WebReadCallList;
import com.uclassify.api._1.requestschema.WebWriteCallList;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;
import com.uclassify.api._1.responseschema.ResponseEntity;

/**
 * @author Nabeel Mukhtar
 *
 */
public abstract class BaseUClassifyClient implements UClassifyClient {

    /** Field description */
    private static final String GZIP_ENCODING = "gzip";

    /** Field description */
    private final SchemaElementFactory OBJECT_FACTORY = createObjectFactory();

    /** The static logger. */
    protected final Logger LOG = Logger.getLogger(getClass().getCanonicalName());
    
    /** Field description */
    private UClassifyConsumer apiConsumer;

    /** Field description */
    private Map<String, String> requestHeaders;

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    protected BaseUClassifyClient(String consumerKey, String consumerSecret) {
        requestHeaders = new HashMap<String, String>();

        // by default we compress contents
        requestHeaders.put("Accept-Encoding", "gzip, deflate");
        apiConsumer = new UClassifyConsumer(consumerKey, consumerSecret);
    }

    /**
     * {@inheritDoc}
     */
    public void setRequestHeaders(Map<String, String> requestHeaders) {
        this.requestHeaders = requestHeaders;
    }

    /**
     * {@inheritDoc}
     */
    public Map<String, String> getRequestHeaders() {
        return requestHeaders;
    }

    /**
     * {@inheritDoc}
     */
    public void addRequestHeader(String headerName, String headerValue) {
        requestHeaders.put(headerName, headerValue);
    }

    /**
     * {@inheritDoc}
     */
    public void removeRequestHeader(String headerName) {
        requestHeaders.remove(headerName);
    }

    /**
     * {@inheritDoc}
     */
    public void setApiConsumer(UClassifyConsumer apiConsumer) {
        this.apiConsumer = apiConsumer;
    }

    /**
     * {@inheritDoc}
     */
    public UClassifyConsumer getApiConsumer() {
        return apiConsumer;
    }
    
	@Override
	public void addClass(String classifierName, String className) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("className", className);
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
        AddClass addClass = OBJECT_FACTORY.createAddClass();
        addClass.setClassName(className);
        addClass.setId(idgenerator.generateId("AddClass"));
        webWriteCallList.getCreateAndRemoveAndAddClass().add(addClass);
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public Map<String, Classification> classify(String classifierName,
			List<String> texts) {
		assertNotNullOrEmpty("API Read Key", getApiConsumer().getReadApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("texts", texts);
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        Map<String, String> textIds = new HashMap<String, String>();
        Map<String, String> classifyIds = new HashMap<String, String>();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        TextList textList = OBJECT_FACTORY.createTextList();
        for (String text : texts) {
        	String id = idgenerator.generateId("Text");
        	textIds.put(text, id);
        	TextBase64 textBase64 = OBJECT_FACTORY.createTextBase64();
        	textBase64.setId(id);
        	textBase64.setValue(Base64.encodeBytes(text.getBytes()));
        	textList.getTextBase64().add(textBase64);
        }
        uclassify.setTexts(textList);
        
        WebReadCallList webReadCallList = OBJECT_FACTORY.createWebReadCallList();
        webReadCallList.setReadApiKey(getApiConsumer().getReadApiKey());
		uclassify.setReadCalls(webReadCallList);
		for (String text : texts) {
	        Classify classify = OBJECT_FACTORY.createClassify();
	        classify.setId(idgenerator.generateId("Classify"));
	        classify.setClassifierName(classifierName);
	        classify.setTextId(textIds.get(text));
	        classifyIds.put(classify.getId(), text);
	        webReadCallList.getClassifyAndGetInformation().add(classify);
		}
        
		List<ResponseEntity> response = readResponse(callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK));
		
		Map<String, Classification> classifications = new HashMap<String, Classification>();
		for (ResponseEntity entity : response) {
			com.uclassify.api._1.responseschema.Classify classify = (com.uclassify.api._1.responseschema.Classify) entity;
			String text = classifyIds.get(classify.getId());
			classifications.put(text, classify.getClassification());
		}
		return classifications;
	}


	@Override
	public Map<String, Classification> classify(String classifierName,
			InputStream texts) {
		return classify(classifierName, getTextsList(texts));
	}

	@Override
	public Map<String, Classification> classify(String userName,
			String classifierName, List<String> texts) {
		assertNotNullOrEmpty("API Read Key", getApiConsumer().getReadApiKey());
		assertNotNullOrEmpty("userName", userName);
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("texts", texts);
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        Map<String, String> textIds = new HashMap<String, String>();
        Map<String, String> classifyIds = new HashMap<String, String>();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        TextList textList = OBJECT_FACTORY.createTextList();
        for (String text : texts) {
        	String id = idgenerator.generateId("Text");
        	textIds.put(text, id);
        	TextBase64 textBase64 = OBJECT_FACTORY.createTextBase64();
        	textBase64.setId(id);
        	textBase64.setValue(Base64.encodeBytes(text.getBytes()));
        	textList.getTextBase64().add(textBase64);
        }
        uclassify.setTexts(textList);
        
        WebReadCallList webReadCallList = OBJECT_FACTORY.createWebReadCallList();
        webReadCallList.setReadApiKey(getApiConsumer().getReadApiKey());
		uclassify.setReadCalls(webReadCallList);
		for (String text : texts) {
	        Classify classify = OBJECT_FACTORY.createClassify();
	        classify.setId(idgenerator.generateId("Classify"));
	        classify.setClassifierName(classifierName);
	        classify.setUsername(userName);
	        classify.setTextId(textIds.get(text));
	        classifyIds.put(classify.getId(), text);
	        webReadCallList.getClassifyAndGetInformation().add(classify);
		}
        
		List<ResponseEntity> response = readResponse(callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK));
		
		Map<String, Classification> classifications = new HashMap<String, Classification>();
		for (ResponseEntity entity : response) {
			com.uclassify.api._1.responseschema.Classify classify = (com.uclassify.api._1.responseschema.Classify) entity;
			String text = classifyIds.get(classify.getId());
			classifications.put(text, classify.getClassification());
		}
		return classifications;
	}

	@Override
	public Map<String, Classification> classify(String userName,
			String classifierName, InputStream texts) {
		return classify(userName, classifierName, getTextsList(texts));
	}

	@Override
	public void createClassifier(String classifierName) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
        Create create = OBJECT_FACTORY.createCreate();
        create.setId(idgenerator.generateId("Create"));
        webWriteCallList.getCreateAndRemoveAndAddClass().add(create);
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public List<ClassInformation> getInformation(String classifierName) {
		assertNotNullOrEmpty("API Read Key", getApiConsumer().getReadApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        
        WebReadCallList webReadCallList = OBJECT_FACTORY.createWebReadCallList();
        webReadCallList.setReadApiKey(getApiConsumer().getReadApiKey());
		uclassify.setReadCalls(webReadCallList);
        GetInformation getInformation = OBJECT_FACTORY.createGetInformation();
        getInformation.setId(idgenerator.generateId("GetInformation"));
        getInformation.setClassifierName(classifierName);
        webReadCallList.getClassifyAndGetInformation().add(getInformation);
        
		List<ResponseEntity> response = readResponse(callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK));
		
		for (ResponseEntity entity : response) {
			com.uclassify.api._1.responseschema.GetInformation getInformationResponse = (com.uclassify.api._1.responseschema.GetInformation) entity;
			if (getInformationResponse.getClasses() != null) {
				return getInformationResponse.getClasses().getClassInformation();
			}
		}
		return Collections.emptyList();
	}

	@Override
	public List<ClassInformation> getInformation(String userName, String classifierName) {
		assertNotNullOrEmpty("API Read Key", getApiConsumer().getReadApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        
        WebReadCallList webReadCallList = OBJECT_FACTORY.createWebReadCallList();
        webReadCallList.setReadApiKey(getApiConsumer().getReadApiKey());
		uclassify.setReadCalls(webReadCallList);
        GetInformation getInformation = OBJECT_FACTORY.createGetInformation();
        getInformation.setId(idgenerator.generateId("GetInformation"));
        getInformation.setClassifierName(classifierName);
        getInformation.setUsername(userName);
        webReadCallList.getClassifyAndGetInformation().add(getInformation);
        
		List<ResponseEntity> response = readResponse(callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK));
		
		for (ResponseEntity entity : response) {
			com.uclassify.api._1.responseschema.GetInformation getInformationResponse = (com.uclassify.api._1.responseschema.GetInformation) entity;
			if (getInformationResponse.getClasses() != null) {
				return getInformationResponse.getClasses().getClassInformation();
			}
		}
		return Collections.emptyList();
	}
	@Override
	public void removeClass(String classifierName, String className) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("className", className);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
        RemoveClass removeClass = OBJECT_FACTORY.createRemoveClass();
        removeClass.setId(idgenerator.generateId("RemoveClass"));
        removeClass.setClassName(className);
        webWriteCallList.getCreateAndRemoveAndAddClass().add(removeClass);
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public void removeClassifier(String classifierName) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
        Remove remove = OBJECT_FACTORY.createRemove();
        remove.setId(idgenerator.generateId("Remove"));
        webWriteCallList.getCreateAndRemoveAndAddClass().add(remove);
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public void train(String classifierName, Map<String, String> trainingTexts) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("trainingTexts", trainingTexts);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        Map<String, String> textIds = new HashMap<String, String>();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        TextList textList = OBJECT_FACTORY.createTextList();
        for (String text : trainingTexts.values()) {
        	String id = idgenerator.generateId("Text");
        	textIds.put(text, id);
        	TextBase64 textBase64 = OBJECT_FACTORY.createTextBase64();
        	textBase64.setId(id);
        	textBase64.setValue(Base64.encodeBytes(text.getBytes()));
        	textList.getTextBase64().add(textBase64);
        }
        uclassify.setTexts(textList);
        
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
		for (Map.Entry<String, String> textEntry: trainingTexts.entrySet()) {
	        Train train = OBJECT_FACTORY.createTrain();
	        train.setId(idgenerator.generateId("Train"));
	        train.setClassName(textEntry.getKey());
	        train.setTextId(textIds.get(textEntry.getValue()));
	        webWriteCallList.getCreateAndRemoveAndAddClass().add(train);
		}
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public void train(String classifierName, InputStream trainingTexts) {
		train(classifierName, getTextsMap(trainingTexts));
	}

	@Override
	public void untrain(String classifierName, Map<String, String> trainingTexts) {
		assertNotNullOrEmpty("API Write Key", getApiConsumer().getWriteApiKey());
		assertNotNullOrEmpty("classifierName", classifierName);
		assertNotNullOrEmpty("trainingTexts", trainingTexts);
		
        UClassifyUrlBuilder builder = createUClassifyUrlBuilder(UClassifyUrls.API_URL);
        IdGenerator idgenerator = IdGenerator.newInstance();
        Map<String, String> textIds = new HashMap<String, String>();
        String                apiUrl  = builder.buildUrl();
        Uclassify uclassify = OBJECT_FACTORY.createUclassify();
        uclassify.setVersion(BigDecimal.valueOf(ApplicationConstants.REQUEST_VERSION));
        TextList textList = OBJECT_FACTORY.createTextList();
        for (String text : trainingTexts.values()) {
        	String id = idgenerator.generateId("Text");
        	textIds.put(text, id);
        	TextBase64 textBase64 = OBJECT_FACTORY.createTextBase64();
        	textBase64.setId(id);
        	textBase64.setValue(Base64.encodeBytes(text.getBytes()));
        	textList.getTextBase64().add(textBase64);
        }
        uclassify.setTexts(textList);
        
        WebWriteCallList webWriteCallList = OBJECT_FACTORY.createWebWriteCallList();
        webWriteCallList.setClassifierName(classifierName);
        webWriteCallList.setWriteApiKey(getApiConsumer().getWriteApiKey());
		uclassify.setWriteCalls(webWriteCallList);
		for (Map.Entry<String, String> textEntry: trainingTexts.entrySet()) {
	        Untrain untrain = OBJECT_FACTORY.createUntrain();
	        untrain.setId(idgenerator.generateId("Train"));
	        untrain.setClassName(textEntry.getKey());
	        untrain.setTextId(textIds.get(textEntry.getValue()));
	        webWriteCallList.getCreateAndRemoveAndAddClass().add(untrain);
		}
        
        callApiMethod(apiUrl, marshallObject(uclassify), ApplicationConstants.CONTENT_TYPE_XML, HttpMethod.POST,
                      HttpURLConnection.HTTP_OK);
	}

	@Override
	public void untrain(String classifierName, InputStream trainingTexts) {
		untrain(classifierName, getTextsMap(trainingTexts));
	}
    
	protected Map<String, String> getTextsMap(InputStream texts) {
		assertNotNull("input-stream", texts);
		Map<String, String> textsMap = new HashMap<String, String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(texts));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				// TODO-NM: Do proper CVS parsing.
				int index = line.indexOf(',');
				if (index > 0 && index < line.length() - 1) {
					textsMap.put(line.substring(0, index), line.substring(index + 1));
				} else {
					textsMap.put(line, line);
				}
			}
		} catch (Exception e) {
			LOG.warning(e.getLocalizedMessage());
		} finally {
			closeStream(texts);
		}
		return textsMap;
	}
	
	protected List<String> getTextsList(InputStream texts) {
		assertNotNull("input-stream", texts);
		List<String> textsList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(texts));
			
			String line = null;
			while ((line = reader.readLine()) != null) {
				textsList.add(line);
			}
		} catch (Exception e) {
			LOG.warning(e.getLocalizedMessage());
		} finally {
			closeStream(texts);
		}
		return textsList;
	}
	
    /**
     * Method description
     *
     *
     *
     *
     * @param clazz
     * @param is
     * @param <T>
     *
     * @return
     */
    protected <T> T readResponse(Class<T> clazz, InputStream is) {
        try {
            return unmarshallObject(clazz, is);
        } finally {
            closeStream(is);
        }
    }

    protected List<ResponseEntity> readResponse(InputStream is) {
    	com.uclassify.api._1.responseschema.Uclassify response = readResponse(com.uclassify.api._1.responseschema.Uclassify.class, is);
    	if (response != null) {
    		if (response.getStatus() != null) {
    			if (response.getStatus().isSuccess()) {
                	return response.getReadCalls().getClassifyAndGetInformation();
    			} else {
    				throw new UClassifyException(response.getStatus().getValue(), response.getStatus().getStatusCode().intValue(), new Date());  				
    			}
    		}
    	}
		throw new UClassifyException("Unable to unmarshal response.");    		
    }
    
    /**
     *
     *
     * @param apiUrl
     * @param xmlContent
     * @param contentType
     * @param method
     * @param expected
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, String xmlContent, String contentType, HttpMethod method,
            int expected) {
        try {
            URL               url     = new URL(apiUrl);
            HttpURLConnection request = (HttpURLConnection) url.openConnection();

            if (ApplicationConstants.CONNECT_TIMEOUT > -1) {
                request.setConnectTimeout(ApplicationConstants.CONNECT_TIMEOUT);
            }

            if (ApplicationConstants.READ_TIMEOUT > -1) {
                request.setReadTimeout(ApplicationConstants.READ_TIMEOUT);
            }

            for (String headerName : requestHeaders.keySet()) {
                request.setRequestProperty(headerName, requestHeaders.get(headerName));
            }

            request.setRequestMethod(method.name());
            request.setDoOutput(true);

            if (contentType != null) {
                request.setRequestProperty("Content-Type", contentType);
            }

            if (xmlContent != null) {
                PrintStream out = new PrintStream(new BufferedOutputStream(request.getOutputStream()));

                out.print(xmlContent);
                out.flush();
                out.close();
            }

            request.connect();

            if (request.getResponseCode() != expected) {
                throw new UClassifyException(convertStreamToString(getWrappedInputStream(request.getErrorStream(),
                        GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()))));
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new UClassifyException(e);
        }
    }

    /**
     * Method description
     *
     *
     * @param is
     *
     */
    protected void closeStream(InputStream is) {
        try {
            is.close();
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while closing stream.", e);	
        }
    }

    /**
     * Method description
     *
     *
     * @param connection
     *
     */
    protected void closeConnection(HttpURLConnection connection) {
        try {
        	if (connection != null) {
        		connection.disconnect();
        	}
        } catch (Exception e) {
        	LOG.log(Level.SEVERE, "An error occurred while disconnecting connection.", e);	
        }
    }
    
    /**
     * Method description
     *
     *
     * @param is
     * @param gzip
     * @return
     * @throws IOException
     */
    protected InputStream getWrappedInputStream(InputStream is, boolean gzip) throws IOException {
        if (gzip) {
            return new BufferedInputStream(new GZIPInputStream(is));
        } else {
            return new BufferedInputStream(is);
        }
    }

    /**
     * Get property as long.
     *
     * @param s
     *
     * @return
     */
    protected boolean isNullOrEmpty(String s) {
        return ((s == null) || (s.length() == 0));
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNullOrEmpty(String name, String value) {
        if (isNullOrEmpty(value)) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNullOrEmpty(String name, Collection<?> value) {
        if ((value == null) || value.isEmpty()) {
            throw new IllegalArgumentException(name + " cannot be null or empty.");
        }
    }

    /**
    *
    *
    * @param name
    * @param value
    */
   protected void assertNotNullOrEmpty(String name, Map<?, ?> value) {
       if ((value == null) || value.isEmpty()) {
           throw new IllegalArgumentException(name + " cannot be null or empty.");
       }
   }
   
    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertPositiveNumber(String name, int value) {
        if (value < 0) {
            throw new IllegalArgumentException(name + " cannot be less than zero.");
        }
    }

    /**
     *
     *
     * @param name
     * @param value
     */
    protected void assertNotNull(String name, Object value) {
        if (value == null) {
            throw new IllegalArgumentException(name + " cannot be null.");
        }
    }
    
	/**
	 * Convert stream to string.
	 * 
	 * @param is the is
	 * 
	 * @return the string
	 */
	protected static String convertStreamToString(InputStream is) {
	    /*
	     * To convert the InputStream to String we use the BufferedReader.readLine()
	     * method. We iterate until the BufferedReader return null which means
	     * there's no more data to read. Each line will appended to a StringBuilder
	     * and returned as String.
	     */
	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	    StringBuilder sb = new StringBuilder();
	
	    String line = null;
	    try {
	        while ((line = reader.readLine()) != null) {
	            sb.append(line + "\n");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            is.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	
	    return sb.toString();
	}
    
    /**
     * Method description
     *
     *
     *
     * @param clazz
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    protected abstract <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent);

    /**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected abstract String marshallObject(Object element);

    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected abstract UClassifyUrlBuilder createUClassifyUrlBuilder(String urlFormat);

    /**
     * Method description
     *
     * @return
     */
    protected abstract SchemaElementFactory createObjectFactory();
}

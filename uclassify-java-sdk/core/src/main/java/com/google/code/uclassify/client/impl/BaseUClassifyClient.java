/**
 *
 */
package com.google.code.uclassify.client.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;

import com.google.code.uclassify.client.SchemaElementFactory;
import com.google.code.uclassify.client.UClassifyClient;
import com.google.code.uclassify.client.UClassifyClientException;
import com.google.code.uclassify.client.UClassifyConsumer;
import com.google.code.uclassify.client.enumeration.HttpMethod;
import com.google.code.uclassify.client.util.ApplicationConstants;
import com.google.code.uclassify.client.util.UClassifyUrls.UClassifyUrlBuilder;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classification;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Classification> classify(String classifierName,
			List<String> texts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Classification> classify(String classifierName,
			InputStream texts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Classification> classify(String userName,
			String classifierName, List<String> texts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Classification> classify(String userName,
			String classifierName, InputStream texts) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createClassifier(String classifierName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ClassInformation> getInformation(String classifierName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeClass(String classifierName, String className) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeClassifier(String classifierName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void train(String classifierName, Map<String, String> trainingTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void train(String classifierName, InputStream trainingTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void untrain(String classifierName, Map<String, String> trainingTexts) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void untrain(String classifierName, InputStream trainingTexts) {
		// TODO Auto-generated method stub
		
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

    /**
     *
     *
     * @param apiUrl
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl) {
        return callApiMethod(apiUrl, HttpURLConnection.HTTP_OK);
    }

    /**
     *
     *
     * @param apiUrl
     * @param expected
     * @param httpHeaders
     *
     * @return
     */
    protected InputStream callApiMethod(String apiUrl, int expected) {
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
            
            request.connect();

            if (request.getResponseCode() != expected) {
                Error error = readResponse(Error.class,
                                           getWrappedInputStream(request.getErrorStream(),
                                               GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new UClassifyClientException(e);
        }
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

            request.setRequestMethod(method.fieldName());
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
                Error error = readResponse(Error.class,
                                           getWrappedInputStream(request.getErrorStream(),
                                               GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding())));

                throw createLinkedInApiClientException(error);
            } else {
                return getWrappedInputStream(request.getInputStream(),
                                             GZIP_ENCODING.equalsIgnoreCase(request.getContentEncoding()));
            }
        } catch (IOException e) {
            throw new UClassifyClientException(e);
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
     * @param error
     * @return
     */
    protected UClassifyClientException createLinkedInApiClientException(Error error) {
        return new UClassifyClientException("", 0, "", new Date());
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
    protected abstract UClassifyUrlBuilder createLinkedInApiUrlBuilder(String urlFormat);

    /**
     * Method description
     *
     * @return
     */
    protected abstract SchemaElementFactory createObjectFactory();
}

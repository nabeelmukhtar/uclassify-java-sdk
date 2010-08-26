/**
 *
 */
package com.google.code.uclassify.client.impl;
import java.io.InputStream;
import java.io.StringWriter;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

import com.google.code.uclassify.client.SchemaElementFactory;
import com.google.code.uclassify.client.UClassifyClientException;
import com.google.code.uclassify.client.constant.ApplicationConstants;
import com.google.code.uclassify.client.constant.UClassifyUrls.UClassifyUrlBuilder;

/**
 * @author Nabeel Mukhtar
 *
 */
public class UClassifyXppClient extends BaseUClassifyClient {

    /** Field description */
    private static final SchemaElementFactory OBJECT_FACTORY = new XppElementFactory();
    
    /** Field description */
	private static final Map<Class<? extends ResponseEntity>, Class<? extends BaseSchemaEntity>> DOM_CLASSES_MAP = new HashMap<Class<? extends ResponseEntity>, Class<? extends BaseSchemaEntity>>();
	
	static {
		DOM_CLASSES_MAP.put(Person.class, PersonImpl.class);
	}
	
    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public UClassifyXppClient(String consumerKey, String consumerSecret) {
        super(consumerKey, consumerSecret);
    }

    /**
     * Method description
     *
     *
     * @param xmlContent
     * @param <T>
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    protected <T> T unmarshallObject(Class<T> clazz, InputStream xmlContent) {
        try {
        	XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        	parser.setInput(xmlContent, ApplicationConstants.CONTENT_ENCODING);
        	
        	if (parser.getEventType() == XmlPullParser.START_DOCUMENT) {
        		parser.nextTag();
        	}

        	BaseSchemaEntity entity = getSchemaEntityByClass(clazz);
        	
        	entity.init(parser);

            return (T) entity;
        } catch (Exception e) {
            throw new UClassifyClientException(e);
        }
    }

	/**
     * Method description
     *
     *
     * @param element
     *
     * @return
     */
    protected String marshallObject(Object element) {
    	if (element instanceof String) {
    		return (String) element;
    	} else if (element instanceof BaseSchemaEntity) {
    		try {
    			StringWriter writer = new StringWriter();
				XmlSerializer serializer = XmlPullParserFactory.newInstance().newSerializer();
				serializer.setOutput(writer);
				((BaseSchemaEntity) element).toXml(serializer);
				serializer.flush();
				return writer.toString();
			} catch (Exception e) {
	    		throw new UClassifyClientException("Unkown element encountered:" + element, e);
			}
    	} else {
    		throw new UClassifyClientException("Unkown element encountered:" + element);
    	}
    }

    /**
     * Method description
     *
     * @return
     */
    protected SchemaElementFactory<?> createObjectFactory() {
    	return OBJECT_FACTORY;
    }
    
    /**
     * Method description
     *
     *
     * @param urlFormat
     *
     * @return
     */
    protected UClassifyUrlBuilder createLinkedInApiUrlBuilder(String urlFormat) {
        return new UClassifyUrlBuilder(urlFormat);
    }
    
    /**
     * Method description
     *
     */
    private BaseSchemaEntity getSchemaEntityByClass(Class<?> clazz) {
    	if (DOM_CLASSES_MAP.containsKey(clazz)) {
    		Class<? extends BaseSchemaEntity> implClass = DOM_CLASSES_MAP.get(clazz);
    		try {
				return implClass.newInstance();
			} catch (Exception e) {
	    		throw new UClassifyClientException("Could not instantiate class: " + implClass.getName(), e);
			}
    	} else {
    		throw new UClassifyClientException("Unknown class encountered in response: " + clazz.getName());
    	}
	}
}

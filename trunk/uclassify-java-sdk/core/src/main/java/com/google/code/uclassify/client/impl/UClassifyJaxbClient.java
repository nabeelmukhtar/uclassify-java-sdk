/**
 *
 */
package com.google.code.uclassify.client.impl;
import java.io.InputStream;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.google.code.uclassify.client.SchemaElementFactory;
import com.google.code.uclassify.client.UClassifyClientException;
import com.google.code.uclassify.client.util.UClassifyUrls.UClassifyUrlBuilder;
import com.uclassify.api._1.requestschema.ObjectFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class UClassifyJaxbClient extends BaseUClassifyClient {

    /** Field description */
    private static final String JAXB_PACKAGE_NAME = "com.google.code.linkedinapi.schema";
    
    /** Field description */
    private static final SchemaElementFactory OBJECT_FACTORY = new JaxbElementFactory();
    
    /** Do not access directly. It may be null!!!. Use {@link #getJaxbContext()} */
    private static JAXBContext JAXB_CONTEXT;

    /**
     * Constructs ...
     *
     *
     * @param consumerKey
     * @param consumerSecret
     */
    public UClassifyJaxbClient(String consumerKey, String consumerSecret) {
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
            Unmarshaller u  = getJaxbContext().createUnmarshaller();

            return (T) u.unmarshal(xmlContent);
        } catch (JAXBException e) {
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
        try {
            StringWriter writer = new StringWriter();
            Marshaller   m = getJaxbContext().createMarshaller();

            m.marshal(element, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new UClassifyClientException(e);
        }
    }

    /**
     * Method description
     *
     * @return
     */
    protected SchemaElementFactory createObjectFactory() {
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
	protected JAXBContext getJaxbContext() throws JAXBException {
		if (JAXB_CONTEXT == null ) {
			JAXB_CONTEXT = JAXBContext.newInstance(JAXB_PACKAGE_NAME);
		}
		return JAXB_CONTEXT;
	}

    /**
     * Method description
     *
     */
	protected void setJaxbContext(JAXBContext context) {
		JAXB_CONTEXT = context;
	}
	
	private static class JaxbElementFactory extends ObjectFactory implements SchemaElementFactory {
		public JaxbElementFactory() {
			super();
		}
	}
}

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
import com.google.code.uclassify.client.UClassifyException;
import com.google.code.uclassify.client.util.UClassifyUrls.UClassifyUrlBuilder;
import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import com.uclassify.api._1.requestschema.ObjectFactory;

/**
 * @author Nabeel Mukhtar
 *
 */
public class UClassifyJaxbClient extends BaseUClassifyClient {

    /** Field description */
    private static final SchemaElementFactory OBJECT_FACTORY = new JaxbElementFactory();
    
    /** Do not access directly. It may be null!!!. Use {@link #getRequestJaxbContext()} */
    private static JAXBContext REQUEST_JAXB_CONTEXT;

    /** Do not access directly. It may be null!!!. Use {@link #getResponseJaxbContext()} */
    private static JAXBContext RESPONSE_JAXB_CONTEXT;
    
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
            Unmarshaller u  = getResponseJaxbContext().createUnmarshaller();

            return (T) u.unmarshal(xmlContent);
        } catch (JAXBException e) {
            throw new UClassifyException(e);
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
            Marshaller   marshaller = getRequestJaxbContext().createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper", new NamespacePrefixMapperImpl());

            marshaller.marshal(element, writer);

            return writer.toString();
        } catch (JAXBException e) {
            throw new UClassifyException(e);
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
    protected UClassifyUrlBuilder createUClassifyUrlBuilder(String urlFormat) {
        return new UClassifyUrlBuilder(urlFormat);
    }

    /**
     * Method description
     *
     */
	protected JAXBContext getRequestJaxbContext() throws JAXBException {
		if (REQUEST_JAXB_CONTEXT == null ) {
			REQUEST_JAXB_CONTEXT = JAXBContext.newInstance("com.uclassify.api._1.requestschema");
		}
		return REQUEST_JAXB_CONTEXT;
	}

	protected JAXBContext getResponseJaxbContext() throws JAXBException {
		if (RESPONSE_JAXB_CONTEXT == null ) {
			RESPONSE_JAXB_CONTEXT = JAXBContext.newInstance("com.uclassify.api._1.responseschema");
		}
		return RESPONSE_JAXB_CONTEXT;
	}
	
	private static class JaxbElementFactory extends ObjectFactory implements SchemaElementFactory {
		public JaxbElementFactory() {
			super();
		}
	}
	
	class NamespacePrefixMapperImpl extends NamespacePrefixMapper {

	    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
	        // I want this namespace to be mapped to "xsi"
	        if( "http://www.w3.org/2001/XMLSchema-instance".equals(namespaceUri) )
	            return "xsi";
	         
	        // I want the namespace foo to be the default namespace.
	        if( "http://api.uclassify.com/1/RequestSchema".equals(namespaceUri) )
	            return "";

	        // otherwise I don't care. Just use the default suggestion, whatever it may be.
	        return suggestion;
	    }
	    
	    public String[] getPreDeclaredNamespaceUris() {
	        return new String[] { "urn:abc", "urn:def" };
	    }
	}
}

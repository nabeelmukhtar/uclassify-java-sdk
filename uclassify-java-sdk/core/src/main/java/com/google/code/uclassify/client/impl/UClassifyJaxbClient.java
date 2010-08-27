/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
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
}

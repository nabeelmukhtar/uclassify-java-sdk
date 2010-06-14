
package com.uclassify.api._1.requestschema;



/**
 * <p>Java class for WebReadCallList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebReadCallList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.uclassify.com/1/RequestSchema}ReadCallList">
 *       &lt;attribute name="readApiKey" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface WebReadCallList
    extends ReadCallList
{


    /**
     * Gets the value of the readApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getReadApiKey();

    /**
     * Sets the value of the readApiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setReadApiKey(String value);

}

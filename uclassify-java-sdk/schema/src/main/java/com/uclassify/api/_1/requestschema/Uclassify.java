
package com.uclassify.api._1.requestschema;

import java.math.BigDecimal;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="texts" type="{http://api.uclassify.com/1/RequestSchema}TextList" minOccurs="0"/>
 *         &lt;choice>
 *           &lt;element name="readCalls" type="{http://api.uclassify.com/1/RequestSchema}WebReadCallList"/>
 *           &lt;element name="writeCalls" type="{http://api.uclassify.com/1/RequestSchema}WebWriteCallList"/>
 *         &lt;/choice>
 *       &lt;/sequence>
 *       &lt;attribute name="version" use="required" type="{http://www.w3.org/2001/XMLSchema}decimal" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Uclassify
    extends RequestEntity
{


    /**
     * Gets the value of the texts property.
     * 
     * @return
     *     possible object is
     *     {@link TextList }
     *     
     */
    TextList getTexts();

    /**
     * Sets the value of the texts property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextList }
     *     
     */
    void setTexts(TextList value);

    /**
     * Gets the value of the readCalls property.
     * 
     * @return
     *     possible object is
     *     {@link WebReadCallList }
     *     
     */
    WebReadCallList getReadCalls();

    /**
     * Sets the value of the readCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebReadCallList }
     *     
     */
    void setReadCalls(WebReadCallList value);

    /**
     * Gets the value of the writeCalls property.
     * 
     * @return
     *     possible object is
     *     {@link WebWriteCallList }
     *     
     */
    WebWriteCallList getWriteCalls();

    /**
     * Sets the value of the writeCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebWriteCallList }
     *     
     */
    void setWriteCalls(WebWriteCallList value);

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    BigDecimal getVersion();

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    void setVersion(BigDecimal value);

}

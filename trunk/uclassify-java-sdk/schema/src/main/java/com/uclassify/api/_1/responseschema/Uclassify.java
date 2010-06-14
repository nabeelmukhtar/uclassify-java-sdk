
package com.uclassify.api._1.responseschema;

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
 *         &lt;element name="status" type="{http://api.uclassify.com/1/ResponseSchema}Status"/>
 *         &lt;element name="readCalls" type="{http://api.uclassify.com/1/ResponseSchema}ResponseReadCallList" minOccurs="0"/>
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
    extends ResponseEntity
{


    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link Status }
     *     
     */
    Status getStatus();

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link Status }
     *     
     */
    void setStatus(Status value);

    /**
     * Gets the value of the readCalls property.
     * 
     * @return
     *     possible object is
     *     {@link ResponseReadCallList }
     *     
     */
    ResponseReadCallList getReadCalls();

    /**
     * Sets the value of the readCalls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResponseReadCallList }
     *     
     */
    void setReadCalls(ResponseReadCallList value);

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


package com.uclassify.api._1.responseschema;

import java.util.List;


/**
 * <p>Java class for ResponseReadCallList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseReadCallList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="classify" type="{http://api.uclassify.com/1/ResponseSchema}Classify" minOccurs="0"/>
 *         &lt;element name="getInformation" type="{http://api.uclassify.com/1/ResponseSchema}GetInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface ResponseReadCallList
    extends ResponseEntity
{


    /**
     * Gets the value of the classifyAndGetInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classifyAndGetInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassifyAndGetInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GetInformation }
     * {@link Classify }
     * 
     * 
     */
    List<ResponseEntity> getClassifyAndGetInformation();

}


package com.uclassify.api._1.responseschema;

import java.util.List;


/**
 * <p>Java class for Classes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Classes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded" minOccurs="0">
 *         &lt;element name="classInformation" type="{http://api.uclassify.com/1/ResponseSchema}ClassInformation"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface Classes
    extends ResponseEntity
{


    /**
     * Gets the value of the classInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the classInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getClassInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ClassInformation }
     * 
     * 
     */
    List<ClassInformation> getClassInformation();

}

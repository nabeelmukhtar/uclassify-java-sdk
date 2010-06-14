
package com.uclassify.api._1.requestschema;

import java.util.List;


/**
 * <p>Java class for TextList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TextList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="textBase64" type="{http://api.uclassify.com/1/RequestSchema}TextBase64"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface TextList
    extends RequestEntity
{


    /**
     * Gets the value of the textBase64 property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the textBase64 property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextBase64().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextBase64 }
     * 
     * 
     */
    List<TextBase64> getTextBase64();

}

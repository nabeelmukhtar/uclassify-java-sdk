
package com.uclassify.api._1.responseschema;

import java.util.List;


/**
 * <p>Java class for ResponseWriteCallList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ResponseWriteCallList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="create" type="{http://api.uclassify.com/1/ResponseSchema}Create" minOccurs="0"/>
 *         &lt;element name="remove" type="{http://api.uclassify.com/1/ResponseSchema}Remove" minOccurs="0"/>
 *         &lt;element name="addClass" type="{http://api.uclassify.com/1/ResponseSchema}AddClass" minOccurs="0"/>
 *         &lt;element name="removeClass" type="{http://api.uclassify.com/1/ResponseSchema}RemoveClass" minOccurs="0"/>
 *         &lt;element name="train" type="{http://api.uclassify.com/1/ResponseSchema}Train" minOccurs="0"/>
 *         &lt;element name="untrain" type="{http://api.uclassify.com/1/ResponseSchema}Untrain" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface ResponseWriteCallList
    extends ResponseEntity
{


    /**
     * Gets the value of the createAndRemoveAndAddClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the createAndRemoveAndAddClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCreateAndRemoveAndAddClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Untrain }
     * {@link AddClass }
     * {@link Train }
     * {@link Remove }
     * {@link RemoveClass }
     * {@link Create }
     * 
     * 
     */
    List<ResponseEntity> getCreateAndRemoveAndAddClass();

}


package com.uclassify.api._1.requestschema;

import java.util.List;


/**
 * <p>Java class for WriteCallList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WriteCallList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence maxOccurs="unbounded">
 *         &lt;element name="create" type="{http://api.uclassify.com/1/RequestSchema}Create" minOccurs="0"/>
 *         &lt;element name="remove" type="{http://api.uclassify.com/1/RequestSchema}Remove" minOccurs="0"/>
 *         &lt;element name="addClass" type="{http://api.uclassify.com/1/RequestSchema}AddClass" minOccurs="0"/>
 *         &lt;element name="removeClass" type="{http://api.uclassify.com/1/RequestSchema}RemoveClass" minOccurs="0"/>
 *         &lt;element name="train" type="{http://api.uclassify.com/1/RequestSchema}Train" minOccurs="0"/>
 *         &lt;element name="untrain" type="{http://api.uclassify.com/1/RequestSchema}Untrain" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="classifierName" use="required" type="{http://api.uclassify.com/1/RequestSchema}RestrictedString" />
 *       &lt;attribute name="maxSize" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface WriteCallList
    extends RequestEntity
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
     * {@link Create }
     * {@link Remove }
     * {@link RemoveClass }
     * {@link Train }
     * {@link AddClass }
     * 
     * 
     */
    List<RequestEntity> getCreateAndRemoveAndAddClass();

    /**
     * Gets the value of the classifierName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getClassifierName();

    /**
     * Sets the value of the classifierName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setClassifierName(String value);

    /**
     * Gets the value of the maxSize property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    Long getMaxSize();

    /**
     * Sets the value of the maxSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setMaxSize(Long value);

}

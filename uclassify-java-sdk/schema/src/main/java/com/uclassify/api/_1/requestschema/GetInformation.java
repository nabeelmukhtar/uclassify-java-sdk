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

package com.uclassify.api._1.requestschema;



/**
 * <p>Java class for GetInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetInformation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="classifierName" use="required" type="{http://api.uclassify.com/1/RequestSchema}RestrictedString" />
 *       &lt;attribute name="id" use="required" type="{http://api.uclassify.com/1/RequestSchema}RestrictedString" />
 *       &lt;attribute name="username" type="{http://api.uclassify.com/1/RequestSchema}RestrictedString" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface GetInformation extends RequestEntity
{


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
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getId();

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setId(String value);

    /**
     * Gets the value of the username property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getUsername();

    /**
     * Sets the value of the username property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setUsername(String value);

}

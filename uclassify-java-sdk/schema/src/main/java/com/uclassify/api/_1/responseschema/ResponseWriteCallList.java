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

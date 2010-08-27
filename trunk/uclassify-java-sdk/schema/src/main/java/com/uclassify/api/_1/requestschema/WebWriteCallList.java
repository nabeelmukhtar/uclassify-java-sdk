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
 * <p>Java class for WebWriteCallList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WebWriteCallList">
 *   &lt;complexContent>
 *     &lt;extension base="{http://api.uclassify.com/1/RequestSchema}WriteCallList">
 *       &lt;attribute name="writeApiKey" use="required" type="{http://api.uclassify.com/1/RequestSchema}Base64String" />
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
public interface WebWriteCallList
    extends WriteCallList
{


    /**
     * Gets the value of the writeApiKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    String getWriteApiKey();

    /**
     * Sets the value of the writeApiKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    void setWriteApiKey(String value);

}

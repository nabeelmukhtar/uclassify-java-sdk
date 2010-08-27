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

package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.ReadCallList;
import com.uclassify.api._1.requestschema.RequestEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadCallList", propOrder = {
    "classifyAndGetInformation"
})
public class ReadCallListImpl
    implements Serializable, ReadCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElements({
        @XmlElement(name = "classify", type = ClassifyImpl.class),
        @XmlElement(name = "getInformation", type = GetInformationImpl.class)
    })
    protected List<RequestEntity> classifyAndGetInformation;

    public List<RequestEntity> getClassifyAndGetInformation() {
        if (classifyAndGetInformation == null) {
            classifyAndGetInformation = new ArrayList<RequestEntity>();
        }
        return this.classifyAndGetInformation;
    }

}

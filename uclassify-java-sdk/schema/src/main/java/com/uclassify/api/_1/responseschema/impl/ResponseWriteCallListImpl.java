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

package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.uclassify.api._1.responseschema.ResponseEntity;
import com.uclassify.api._1.responseschema.ResponseWriteCallList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseWriteCallList", propOrder = {
    "createAndRemoveAndAddClass"
})
public class ResponseWriteCallListImpl
    implements Serializable, ResponseWriteCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElements({
        @XmlElement(name = "untrain", type = UntrainImpl.class),
        @XmlElement(name = "addClass", type = AddClassImpl.class),
        @XmlElement(name = "train", type = TrainImpl.class),
        @XmlElement(name = "remove", type = RemoveImpl.class),
        @XmlElement(name = "removeClass", type = RemoveClassImpl.class),
        @XmlElement(name = "create", type = CreateImpl.class)
    })
    protected List<ResponseEntity> createAndRemoveAndAddClass;

    public List<ResponseEntity> getCreateAndRemoveAndAddClass() {
        if (createAndRemoveAndAddClass == null) {
            createAndRemoveAndAddClass = new ArrayList<ResponseEntity>();
        }
        return this.createAndRemoveAndAddClass;
    }

}

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
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.ResponseReadCallList;
import com.uclassify.api._1.responseschema.Status;
import com.uclassify.api._1.responseschema.Uclassify;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "readCalls"
})
@XmlRootElement(name = "uclassify")
public class UclassifyImpl
    implements Serializable, Uclassify
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = StatusImpl.class)
    protected StatusImpl status;
    @XmlElement(type = ResponseReadCallListImpl.class)
    protected ResponseReadCallListImpl readCalls;
    @XmlAttribute(required = true)
    protected BigDecimal version;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status value) {
        this.status = ((StatusImpl) value);
    }

    public ResponseReadCallList getReadCalls() {
        return readCalls;
    }

    public void setReadCalls(ResponseReadCallList value) {
        this.readCalls = ((ResponseReadCallListImpl) value);
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal value) {
        this.version = value;
    }

}

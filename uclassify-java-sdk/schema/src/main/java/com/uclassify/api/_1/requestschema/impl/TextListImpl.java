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
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.TextBase64;
import com.uclassify.api._1.requestschema.TextList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextList", propOrder = {
    "textBase64"
})
public class TextListImpl
    implements Serializable, TextList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = TextBase64Impl.class)
    protected List<TextBase64> textBase64;

    public List<TextBase64> getTextBase64() {
        if (textBase64 == null) {
            textBase64 = new ArrayList<TextBase64>();
        }
        return this.textBase64;
    }

}
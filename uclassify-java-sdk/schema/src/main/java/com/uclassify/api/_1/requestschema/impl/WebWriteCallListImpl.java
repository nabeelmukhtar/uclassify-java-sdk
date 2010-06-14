
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.WebWriteCallList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebWriteCallList")
public class WebWriteCallListImpl
    extends WriteCallListImpl
    implements Serializable, WebWriteCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String writeApiKey;

    public String getWriteApiKey() {
        return writeApiKey;
    }

    public void setWriteApiKey(String value) {
        this.writeApiKey = value;
    }

}


package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.WebReadCallList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WebReadCallList")
public class WebReadCallListImpl
    extends ReadCallListImpl
    implements Serializable, WebReadCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute
    protected String readApiKey;

    public String getReadApiKey() {
        return readApiKey;
    }

    public void setReadApiKey(String value) {
        this.readApiKey = value;
    }

}


package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.Untrain;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Untrain")
public class UntrainImpl implements Serializable, Untrain
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String className;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute(required = true)
    protected String textId;

    public String getClassName() {
        return className;
    }

    public void setClassName(String value) {
        this.className = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

    public String getTextId() {
        return textId;
    }

    public void setTextId(String value) {
        this.textId = value;
    }

}
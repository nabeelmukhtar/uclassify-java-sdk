
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.Classify;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Classify")
public class ClassifyImpl implements Serializable, Classify
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String classifierName;
    @XmlAttribute(required = true)
    protected String id;
    @XmlAttribute(required = true)
    protected String textId;
    @XmlAttribute
    protected String username;

    public String getClassifierName() {
        return classifierName;
    }

    public void setClassifierName(String value) {
        this.classifierName = value;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

}

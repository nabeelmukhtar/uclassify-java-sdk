
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.GetInformation;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInformation")
public class GetInformationImpl implements Serializable, GetInformation
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String classifierName;
    @XmlAttribute(required = true)
    protected String id;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

}

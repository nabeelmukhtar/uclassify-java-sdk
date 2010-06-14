
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.RemoveClass;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RemoveClass")
public class RemoveClassImpl implements Serializable, RemoveClass
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String className;
    @XmlAttribute(required = true)
    protected String id;

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

}

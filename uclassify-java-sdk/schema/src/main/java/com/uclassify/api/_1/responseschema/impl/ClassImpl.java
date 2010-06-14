
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.uclassify.api._1.responseschema.Class;
import org.w3._2001.xmlschema.Adapter2;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Class")
public class ClassImpl
    implements Serializable, Class
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String className;
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(Adapter2 .class)
    protected Double p;

    public String getClassName() {
        return className;
    }

    public void setClassName(String value) {
        this.className = value;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double value) {
        this.p = value;
    }

}


package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.Untrain;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Untrain")
public class UntrainImpl implements Serializable, Untrain
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlAttribute(required = true)
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}
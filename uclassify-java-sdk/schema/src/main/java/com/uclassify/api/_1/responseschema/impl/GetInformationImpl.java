
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.Classes;
import com.uclassify.api._1.responseschema.GetInformation;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetInformation", propOrder = {
    "classes"
})
public class GetInformationImpl implements Serializable, GetInformation
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = ClassesImpl.class)
    protected ClassesImpl classes;
    @XmlAttribute(required = true)
    protected String id;

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes value) {
        this.classes = ((ClassesImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}

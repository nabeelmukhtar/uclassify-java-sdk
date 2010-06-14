
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.Classification;
import com.uclassify.api._1.responseschema.Classify;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Classify", propOrder = {
    "classification"
})
public class ClassifyImpl implements Serializable, Classify
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = ClassificationImpl.class)
    protected ClassificationImpl classification;
    @XmlAttribute(required = true)
    protected String id;

    public Classification getClassification() {
        return classification;
    }

    public void setClassification(Classification value) {
        this.classification = ((ClassificationImpl) value);
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }

}

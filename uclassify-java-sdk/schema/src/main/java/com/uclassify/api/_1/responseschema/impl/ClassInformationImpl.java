
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import com.uclassify.api._1.responseschema.ClassInformation;
import org.w3._2001.xmlschema.Adapter1;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ClassInformation", propOrder = {
    "uniqueFeatures",
    "totalCount"
})
public class ClassInformationImpl
    implements Serializable, ClassInformation
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long uniqueFeatures;
    @XmlElement(required = true, type = String.class)
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long totalCount;
    @XmlAttribute(required = true)
    protected String className;

    public Long getUniqueFeatures() {
        return uniqueFeatures;
    }

    public void setUniqueFeatures(Long value) {
        this.uniqueFeatures = value;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long value) {
        this.totalCount = value;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String value) {
        this.className = value;
    }

}


package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.uclassify.api._1.requestschema.RequestEntity;
import com.uclassify.api._1.requestschema.WriteCallList;
import org.w3._2001.xmlschema.Adapter1;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WriteCallList", propOrder = {
    "createAndRemoveAndAddClass"
})
public class WriteCallListImpl
    implements Serializable, WriteCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElements({
        @XmlElement(name = "untrain", type = UntrainImpl.class),
        @XmlElement(name = "create", type = CreateImpl.class),
        @XmlElement(name = "remove", type = RemoveImpl.class),
        @XmlElement(name = "removeClass", type = RemoveClassImpl.class),
        @XmlElement(name = "train", type = TrainImpl.class),
        @XmlElement(name = "addClass", type = AddClassImpl.class)
    })
    protected List<RequestEntity> createAndRemoveAndAddClass;
    @XmlAttribute(required = true)
    protected String classifierName;
    @XmlAttribute
    @XmlJavaTypeAdapter(Adapter1 .class)
    protected Long maxSize;

    public List<RequestEntity> getCreateAndRemoveAndAddClass() {
        if (createAndRemoveAndAddClass == null) {
            createAndRemoveAndAddClass = new ArrayList<RequestEntity>();
        }
        return this.createAndRemoveAndAddClass;
    }

    public String getClassifierName() {
        return classifierName;
    }

    public void setClassifierName(String value) {
        this.classifierName = value;
    }

    public Long getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(Long value) {
        this.maxSize = value;
    }

}

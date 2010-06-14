
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.ReadCallList;
import com.uclassify.api._1.requestschema.RequestEntity;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadCallList", propOrder = {
    "classifyAndGetInformation"
})
public class ReadCallListImpl
    implements Serializable, ReadCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElements({
        @XmlElement(name = "classify", type = ClassifyImpl.class),
        @XmlElement(name = "getInformation", type = GetInformationImpl.class)
    })
    protected List<RequestEntity> classifyAndGetInformation;

    public List<RequestEntity> getClassifyAndGetInformation() {
        if (classifyAndGetInformation == null) {
            classifyAndGetInformation = new ArrayList<RequestEntity>();
        }
        return this.classifyAndGetInformation;
    }

}

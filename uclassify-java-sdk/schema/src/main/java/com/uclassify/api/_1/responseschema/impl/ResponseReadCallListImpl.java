
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlType;

import com.uclassify.api._1.responseschema.ResponseEntity;
import com.uclassify.api._1.responseschema.ResponseReadCallList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ResponseReadCallList", propOrder = {
    "classifyAndGetInformation"
})
public class ResponseReadCallListImpl
    implements Serializable, ResponseReadCallList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElements({
        @XmlElement(name = "getInformation", type = GetInformationImpl.class),
        @XmlElement(name = "classify", type = ClassifyImpl.class)
    })
    protected List<ResponseEntity> classifyAndGetInformation;

    public List<ResponseEntity> getClassifyAndGetInformation() {
        if (classifyAndGetInformation == null) {
            classifyAndGetInformation = new ArrayList<ResponseEntity>();
        }
        return this.classifyAndGetInformation;
    }

}


package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.Class;
import com.uclassify.api._1.responseschema.Classification;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Classification", propOrder = {
    "clazz"
})
public class ClassificationImpl
    implements Serializable, Classification
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(name = "class", required = true, type = ClassImpl.class)
    protected List<Class> clazz;

    public List<Class> getClazz() {
        if (clazz == null) {
            clazz = new ArrayList<Class>();
        }
        return this.clazz;
    }

}

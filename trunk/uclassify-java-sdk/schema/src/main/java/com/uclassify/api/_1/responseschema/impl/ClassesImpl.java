
package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.ClassInformation;
import com.uclassify.api._1.responseschema.Classes;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Classes", propOrder = {
    "classInformation"
})
public class ClassesImpl
    implements Serializable, Classes
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = ClassInformationImpl.class)
    protected List<ClassInformation> classInformation;

    public List<ClassInformation> getClassInformation() {
        if (classInformation == null) {
            classInformation = new ArrayList<ClassInformation>();
        }
        return this.classInformation;
    }

}


package com.uclassify.api._1.responseschema.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.responseschema.ResponseReadCallList;
import com.uclassify.api._1.responseschema.Status;
import com.uclassify.api._1.responseschema.Uclassify;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "status",
    "readCalls"
})
@XmlRootElement(name = "uclassify")
public class UclassifyImpl
    implements Serializable, Uclassify
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = StatusImpl.class)
    protected StatusImpl status;
    @XmlElement(type = ResponseReadCallListImpl.class)
    protected ResponseReadCallListImpl readCalls;
    @XmlAttribute(required = true)
    protected BigDecimal version;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status value) {
        this.status = ((StatusImpl) value);
    }

    public ResponseReadCallList getReadCalls() {
        return readCalls;
    }

    public void setReadCalls(ResponseReadCallList value) {
        this.readCalls = ((ResponseReadCallListImpl) value);
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal value) {
        this.version = value;
    }

}

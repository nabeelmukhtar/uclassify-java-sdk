
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.TextList;
import com.uclassify.api._1.requestschema.Uclassify;
import com.uclassify.api._1.requestschema.WebReadCallList;
import com.uclassify.api._1.requestschema.WebWriteCallList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "texts",
    "readCalls",
    "writeCalls"
})
@XmlRootElement(name = "uclassify")
public class UclassifyImpl
    implements Serializable, Uclassify
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(type = TextListImpl.class)
    protected TextListImpl texts;
    @XmlElement(type = WebReadCallListImpl.class)
    protected WebReadCallListImpl readCalls;
    @XmlElement(type = WebWriteCallListImpl.class)
    protected WebWriteCallListImpl writeCalls;
    @XmlAttribute(required = true)
    protected BigDecimal version;

    public TextList getTexts() {
        return texts;
    }

    public void setTexts(TextList value) {
        this.texts = ((TextListImpl) value);
    }

    public WebReadCallList getReadCalls() {
        return readCalls;
    }

    public void setReadCalls(WebReadCallList value) {
        this.readCalls = ((WebReadCallListImpl) value);
    }

    public WebWriteCallList getWriteCalls() {
        return writeCalls;
    }

    public void setWriteCalls(WebWriteCallList value) {
        this.writeCalls = ((WebWriteCallListImpl) value);
    }

    public BigDecimal getVersion() {
        return version;
    }

    public void setVersion(BigDecimal value) {
        this.version = value;
    }

}

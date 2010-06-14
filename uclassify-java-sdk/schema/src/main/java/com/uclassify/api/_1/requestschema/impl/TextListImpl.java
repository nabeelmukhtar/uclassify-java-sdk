
package com.uclassify.api._1.requestschema.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.uclassify.api._1.requestschema.TextBase64;
import com.uclassify.api._1.requestschema.TextList;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TextList", propOrder = {
    "textBase64"
})
public class TextListImpl
    implements Serializable, TextList
{

    private final static long serialVersionUID = 2461660169443089969L;
    @XmlElement(required = true, type = TextBase64Impl.class)
    protected List<TextBase64> textBase64;

    public List<TextBase64> getTextBase64() {
        if (textBase64 == null) {
            textBase64 = new ArrayList<TextBase64>();
        }
        return this.textBase64;
    }

}

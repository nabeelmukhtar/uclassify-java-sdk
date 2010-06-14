
package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Long>
{


    public Long unmarshal(String value) {
        return new Long(value);
    }

    public String marshal(Long value) {
        return value.toString();
    }

}

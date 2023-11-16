package com.example.desktop.laptop;

import lombok.Setter;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "param1",
        "value1",
        "param2",
        "value2",
        "param3",
        "value3",
        "param4",
        "value4",
        "param5",
        "value5"
})
@XmlRootElement(name = "saveByQualitiesRequest", namespace = "http://lab3.pl/soap-example")
@Setter
public class SaveByQualitiesRequest {

    protected String param1;
    protected String value1;
    protected String param2;
    protected String value2;
    protected String param3;
    protected String value3;
    protected String param4;
    protected String value4;
    protected String param5;
    protected String value5;


    @XmlElement(required = true)
    public String getParam1() {
        return param1;
    }

    @XmlElement(required = true)
    public String getValue1() {
        return value1;
    }

    @XmlElement(required = true)
    public String getParam2() {
        return param2;
    }

    @XmlElement(required = true)
    public String getValue2() {
        return value2;
    }

    @XmlElement(required = true)
    public String getParam3() {
        return param3;
    }

    @XmlElement(required = true)
    public String getValue3() {
        return value3;
    }

    @XmlElement(required = true)
    public String getParam4() {
        return param4;
    }

    @XmlElement(required = true)
    public String getValue4() {
        return value4;
    }

    @XmlElement(required = true)
    public String getParam5() {
        return param5;
    }

    @XmlElement(required = true)
    public String getValue5() {
        return value5;
    }
}

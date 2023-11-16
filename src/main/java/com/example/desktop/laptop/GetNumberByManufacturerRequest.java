package com.example.desktop.laptop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getNumberByManufacturerRequest", namespace = "http://lab3.pl/soap-example")
public class GetNumberByManufacturerRequest {

    private String manufacturer;

    @XmlElement(required = true)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}

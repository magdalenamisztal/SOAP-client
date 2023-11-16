package com.example.desktop.laptop;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "getNumberByManufacturerResponse", namespace = "http://lab3.pl/soap-example")
public class GetNumberByManufacturerResponse {

    private int number;

    @XmlElement(required = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

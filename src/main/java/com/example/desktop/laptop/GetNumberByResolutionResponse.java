package com.example.desktop.laptop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getNumberByResolutionResponse", namespace = "http://lab3.pl/soap-example")
public class GetNumberByResolutionResponse {

    private int number;

    @XmlElement(required = true)
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}

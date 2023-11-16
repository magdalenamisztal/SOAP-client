package com.example.desktop.laptop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getResponse", namespace = "http://lab3.pl/soap-example")
public class GetResponse {

    private Laptop laptop;

    @XmlElement(required = true)
    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}

package com.example.desktop.laptop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getLaptop", namespace = "http://lab3.pl/soap-example")
public class GetLaptop {

    private long id;

    @XmlElement(required = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}

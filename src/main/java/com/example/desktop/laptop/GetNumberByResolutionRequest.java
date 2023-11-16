package com.example.desktop.laptop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "getNumberByResolutionRequest", namespace = "http://lab3.pl/soap-example")
public class GetNumberByResolutionRequest {

    private String resolution;

    @XmlElement(required = true)
    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

}

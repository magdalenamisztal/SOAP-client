package com.example.desktop.laptop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "laptop", namespace = "http://lab3.pl/soap-example")
public class Laptop {

    private long id;
    private String manufacturer;
    private String screenSize;
    private String screenResolution;
    private String screenType;
    private String touchScreen;
    private String processor;
    private String physicalCores;
    private String clockSpeed;
    private String ram;
    private String discStorage;
    private String discType;
    private String graphicCard;
    private String graphicCardMemory;
    private String os;
    private String discReader;

    @XmlElement(required = true)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @XmlElement(required = true)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @XmlElement(required = true)
    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    @XmlElement(required = true)
    public String getScreenResolution() {
        return screenResolution;
    }

    public void setScreenResolution(String screenResolution) {
        this.screenResolution = screenResolution;
    }

    @XmlElement(required = true)
    public String getScreenType() {
        return screenType;
    }

    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }

    @XmlElement(required = true)
    public String getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(String touchScreen) {
        this.touchScreen = touchScreen;
    }

    @XmlElement(required = true)
    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    @XmlElement(required = true)
    public String getPhysicalCores() {
        return physicalCores;
    }

    public void setPhysicalCores(String physicalCores) {
        this.physicalCores = physicalCores;
    }

    @XmlElement(required = true)
    public String getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(String clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    @XmlElement(required = true)
    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    @XmlElement(required = true)
    public String getDiscStorage() {
        return discStorage;
    }

    public void setDiscStorage(String discStorage) {
        this.discStorage = discStorage;
    }

    @XmlElement(required = true)
    public String getDiscType() {
        return discType;
    }

    public void setDiscType(String discType) {
        this.discType = discType;
    }

    @XmlElement(required = true)
    public String getGraphicCard() {
        return graphicCard;
    }

    public void setGraphicCard(String graphicCard) {
        this.graphicCard = graphicCard;
    }

    @XmlElement(required = true)
    public String getGraphicCardMemory() {
        return graphicCardMemory;
    }

    public void setGraphicCardMemory(String graphicCardMemory) {
        this.graphicCardMemory = graphicCardMemory;
    }

    @XmlElement(required = true)
    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    @XmlElement(required = true)
    public String getDiscReader() {
        return discReader;
    }

    public void setDiscReader(String discReader) {
        this.discReader = discReader;
    }
}

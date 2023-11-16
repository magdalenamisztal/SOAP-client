package com.example.desktop;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebService
public class LaptopService {

    private String serviceUrl;

    public void setServiceUrl(String serviceUrl) {
        this.serviceUrl = serviceUrl;
    }

    public SOAPMessage createSoapMessage(String localPart, String stringElement, String value) {
        try {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            soapEnvelope.addNamespaceDeclaration("std", "http://lab3.pl/soap-example");

            SOAPBody soapBody = soapEnvelope.getBody();
            QName qName = new QName("http://lab3.pl/soap-example", localPart, "std");
            SOAPElement requestElement = soapBody.addChildElement(qName);

            SOAPElement element = requestElement.addChildElement(stringElement);
            element.addTextNode(value);

            return soapMessage;

        } catch (SOAPException e) {
            e.printStackTrace();
            return null;
        }
    }

    public int getNumberByManufacturer(String manufacturer) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            SOAPMessage soapMessage = createSoapMessage("getNumberByManufacturerRequest", "manufacturer", manufacturer);

            URL endpointUrl = new URL(serviceUrl);

            ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();
            soapMessage.writeTo(requestOutputStream);
            System.out.println("Zapytanie SOAP:");
            System.out.println(requestOutputStream.toString());

            SOAPMessage response = soapConnection.call(soapMessage, endpointUrl);

            SOAPBody responseBody = response.getSOAPBody();
            SOAPElement numberElement = (SOAPElement) responseBody.getElementsByTagName("number").item(0);

            soapConnection.close();

            return Integer.parseInt(numberElement.getValue());
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getNumberByResolution(String resolution) {
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = createSoapMessage("getNumberByResolutionRequest", "resolution", resolution);

            URL endpointUrl = new URL(serviceUrl);

            ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();
            soapMessage.writeTo(requestOutputStream);
            System.out.println("Zapytanie SOAP:");
            System.out.println(requestOutputStream.toString());

            SOAPMessage response = soapConnection.call(soapMessage, endpointUrl);

            SOAPBody responseBody = response.getSOAPBody();
            SOAPElement numberElement = (SOAPElement) responseBody.getElementsByTagName("number").item(0);

            soapConnection.close();

            return Integer.parseInt(numberElement.getValue());
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int getNumberByQualities(Map<String, String> chosenQualities) { //(String resolution)
        try {
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();

            SOAPPart soapPart = soapMessage.getSOAPPart();
            SOAPEnvelope soapEnvelope = soapPart.getEnvelope();
            soapEnvelope.addNamespaceDeclaration("soap", "http://schemas.xmlsoap.org/soap/envelope/");
            soapEnvelope.addNamespaceDeclaration("std", "http://lab3.pl/soap-example");

            SOAPBody soapBody = soapEnvelope.getBody();
            QName qName = new QName("http://lab3.pl/soap-example", "saveByQualitiesRequest", "std");
            SOAPElement requestElement = soapBody.addChildElement(qName);

            List<String> keys = new ArrayList<>(chosenQualities.keySet());

            SOAPElement param1 = requestElement.addChildElement("param1");
            param1.addTextNode(keys.get(0));
            SOAPElement value1 = requestElement.addChildElement("value1");
            value1.addTextNode(chosenQualities.get(keys.get(0)));

            SOAPElement param2 = requestElement.addChildElement("param2");
            param2.addTextNode(keys.get(1));
            SOAPElement value2 = requestElement.addChildElement("value2");
            value2.addTextNode(chosenQualities.get(keys.get(1)));

            SOAPElement param3 = requestElement.addChildElement("param3");
            param3.addTextNode(keys.get(2));
            SOAPElement value3 = requestElement.addChildElement("value3");
            value3.addTextNode(chosenQualities.get(keys.get(2)));

            SOAPElement param4 = requestElement.addChildElement("param4");
            param4.addTextNode(keys.get(3));
            SOAPElement value4 = requestElement.addChildElement("value4");
            value4.addTextNode(chosenQualities.get(keys.get(3)));

            SOAPElement param5 = requestElement.addChildElement("param5");
            param5.addTextNode(keys.get(4));
            SOAPElement value5 = requestElement.addChildElement("value5");
            value5.addTextNode(chosenQualities.get(keys.get(4)));

            URL endpointUrl = new URL(serviceUrl);

            ByteArrayOutputStream requestOutputStream = new ByteArrayOutputStream();
            soapMessage.writeTo(requestOutputStream);
            System.out.println("Zapytanie SOAP:");
            System.out.println(requestOutputStream.toString());

            SOAPMessage response = soapConnection.call(soapMessage, endpointUrl);

            SOAPBody responseBody = response.getSOAPBody();
            SOAPElement numberElement = (SOAPElement) responseBody.getElementsByTagName("number").item(0);

            soapConnection.close();

            return Integer.parseInt(numberElement.getValue());
        } catch (SOAPException | IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}

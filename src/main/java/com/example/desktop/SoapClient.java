package com.example.desktop;

import com.example.desktop.laptop.GetNumberByManufacturerRequest;
import com.example.desktop.laptop.GetNumberByResolutionRequest;
import com.example.desktop.laptop.SaveByQualitiesRequest;

import java.util.Map;

public class SoapClient {

    private LaptopService laptopService;

    public SoapClient(String serviceUrl) {
        this.laptopService = new LaptopService();
        laptopService.setServiceUrl(serviceUrl);
    }

    public static void main(String[] args) {
        System.out.println("MAIN w class SoapClient");

        // URL usługi webowej
        //String serviceUrl = "http://localhost:8080/ws/laptops";
        String serviceUrl = "http://localhost:8080/ws";

        //SoapClient soapClient = new SoapClient();
        SoapClient soapClient = new SoapClient(serviceUrl);

        // Utwórz fabrykę proxy
       /* JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        factory.setServiceClass(LaptopService.class);
        factory.setAddress(serviceUrl);

        // Uzyskaj dostęp do usługi
        LaptopService laptopService = (LaptopService) factory.create();
*/

        String manufacturer = "Sony"; // Ustaw swoją wartość
        GetNumberByManufacturerRequest request = new GetNumberByManufacturerRequest();
        request.setManufacturer(manufacturer);

        /*GetNumberByManufacturerResponse response = laptopService.getNumberByManufacturerResponse(request);

        // Wyświetl wynik
        System.out.println("Number for manufacturer " + manufacturer + ": " + response.getNumber());*/
        int number = soapClient.getLaptopsNumberByManufacturer(manufacturer);
        System.out.println("Number for manufacturer " + manufacturer + ": " + number);

/*
        // Wywołaj metodę usługi
        String resolution = "1600x900"; // Ustaw swoją wartość
        GetNumberByResolutionRequest request = new GetNumberByResolutionRequest();
        request.setResolution(resolution);

        GetNumberByResolutionResponse response = laptopService.getNumberByResolution(request);

        // Wyświetl wynik
        System.out.println("Number for resolution " + resolution + ": " + response.getNumber());*/
    }

    public int getLaptopsNumberByManufacturer(String manufacturer) {
        GetNumberByManufacturerRequest request = new GetNumberByManufacturerRequest();
        request.setManufacturer(manufacturer);

        int number = laptopService.getNumberByManufacturer(manufacturer);
        return number;
    }

    public int getLaptopsNumberByRatio(String resolution) {
        GetNumberByResolutionRequest request = new GetNumberByResolutionRequest();
        request.setResolution(resolution);

        int number = laptopService.getNumberByResolution(resolution);
        return number;
    }

    public int saveByQualities(Map<String, String> chosenQualities) {
        SaveByQualitiesRequest request = new SaveByQualitiesRequest();

        int number = laptopService.getNumberByQualities(chosenQualities);
        return number;
    }

}

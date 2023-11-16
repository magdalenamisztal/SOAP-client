package com.example.desktop;

import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;

@RequiredArgsConstructor
@Component
public class DesktopController {

	private final HostServices hostServices;
	public TextField value1TextField;
	public TextField value2TextField;
	public TextField value3TextField;
	public TextField value4TextField;
	public TextField value5TextField;

	@FXML
	private TextField manufacturerTextField;
	@FXML
	private TextField resolutionTextField;
	@FXML
	private ComboBox<String> comboBox1;
	@FXML
	private ComboBox<String> comboBox2;
	@FXML
	private ComboBox<String> comboBox3;
	@FXML
	private ComboBox<String> comboBox4;
	@FXML
	private ComboBox<String> comboBox5;

	public String getManufacturerInfo() {
		return manufacturerTextField.getText();
	}
	public String getResolutionInfo() {
		return resolutionTextField.getText();
	}

	public void initialize() {
		List<String> items = Arrays.asList("Producent", "Wielkość matrycy", "Rozdzielczość", "Typ matrycy",
				"Czy dotykowy ekran", "Procesor", "Liczba rdzeni fizycznych", "Taktowanie", "RAM", "Pojemność dysku",
				"Typ dysku", "Karta graficzna", "Pamięć karty graficznej", "System operacyjny", "Napęd optyczny");
		comboBox1.getItems().addAll(items);
		comboBox1.getSelectionModel().selectFirst();
		comboBox2.getItems().addAll(items);
		comboBox3.getItems().addAll(items);
		comboBox4.getItems().addAll(items);
		comboBox5.getItems().addAll(items);
	}

	@FXML
	private void onManufacturerButtonClick(ActionEvent event) {
		String manufacturer = getManufacturerInfo();

		SoapClient soapClient = new SoapClient("http://localhost:8080/ws");

		int laptopCount = getLaptopCountByManufacturer(soapClient, manufacturer);//12346;

		displayResult("Liczba laptopów wg producenta",
				"Liczba laptopów " + manufacturer + ": " + laptopCount);
	}

	private int getLaptopCountByManufacturer(SoapClient soapClient, String manufacturer) {
		int number = soapClient.getLaptopsNumberByManufacturer(manufacturer);
		return number;
	}

	@FXML
	private void onScreenRatioButtonClick(ActionEvent event) {
		String screenRatio = getResolutionInfo();
		SoapClient soapClient = new SoapClient("http://localhost:8080/ws");

		int laptopCount = getLaptopCountByScreenRatio(soapClient, screenRatio);

		displayResult("Liczba laptopów wg proporcji ekranu", "Liczba laptopów: " + laptopCount);
	}

	private int getLaptopCountByScreenRatio(SoapClient soapClient, String screenRatio) {
		int number = soapClient.getLaptopsNumberByRatio(screenRatio);
		return number;
	}

	@FXML
	private void onExportButtonClick(ActionEvent event) {

		Map<String, String> chosenQualities = getChosenQualities();
		SoapClient soapClient = new SoapClient("http://localhost:8080/ws");

		int number = soapClient.saveByQualities(chosenQualities);
		displayResult("Eksport danych", "Dane zostały zapisane do pliku XML.");
	}

	private Map<String, String> getChosenQualities() {
		System.out.println("getChosenQualities");
		Map<String, String> qualitiesMap = new HashMap<>();
		qualitiesMap.put(comboBoxGetValue(comboBox1), value1TextField.getText());
		qualitiesMap.put(comboBoxGetValue(comboBox2), value2TextField.getText());
		qualitiesMap.put(comboBoxGetValue(comboBox3), value3TextField.getText());
		qualitiesMap.put(comboBoxGetValue(comboBox4), value4TextField.getText());
		qualitiesMap.put(comboBoxGetValue(comboBox5), value5TextField.getText());

		Iterator<Map.Entry<String, String>> iterator = qualitiesMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
		}
		return qualitiesMap;
	}

	private String comboBoxGetValue(ComboBox comboBox) {
		String value = comboBox.getValue().toString();

		if(value.equals("Producent")) {
			return "manufacturer";
		}
		else if(value.equals("Wielkość matrycy")) {
			return "screenSize";
		}
		else if(value.equals("Rozdzielczość")){
			return "screenResolution";
		}
		else if(value.equals("Typ matrycy")){
			return "screenType";
		}
		else if(value.equals("Czy dotykowy ekran")){
			return "touchScreen";
		}
		else if(value.equals("Procesor")){
			return "processor";
		}
		else if(value.equals("Liczba rdzeni fizycznych")){
			return "physicalCores";
		}
		else if(value.equals("Taktowanie")){
			return "clockSpeed";
		}
		else if(value.equals("RAM")){
			return "ram";
		}
		else if(value.equals("Pojemność dysku")){
			return "discStorage";
		}
		else if(value.equals("Typ dysku")){
			return "discType";
		}
		else if(value.equals("Karta graficzna")){
			return "graphicCard";
		}
		else if(value.equals("Pamięć karty graficznej")){
			return "graphicCardMemory";
		}
		else if(value.equals("System operacyjny")){
			return "os";
		}
		else if(value.equals("Napęd optyczny")){
			return "discReader";
		}

		return value;
	}

	private void displayResult(String title, String content) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(title);
		alert.setHeaderText(null);
		alert.setContentText(content);
		alert.showAndWait();
	}

}

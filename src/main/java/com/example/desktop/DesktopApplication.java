package com.example.desktop;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;

@SpringBootApplication
@Configuration
@EnableWs
public class DesktopApplication extends WsConfigurerAdapter {

	public static void main(String[] args) {
		Application.launch(JavaFxApplication.class, args);
	}

}

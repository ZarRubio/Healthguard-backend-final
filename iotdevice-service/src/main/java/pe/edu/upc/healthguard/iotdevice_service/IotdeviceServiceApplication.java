package pe.edu.upc.healthguard.iotdevice_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@EnableWebSecurity
@SpringBootApplication
public class IotdeviceServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IotdeviceServiceApplication.class, args);
	}

}

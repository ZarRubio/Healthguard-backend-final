package pe.edu.upc.sellmaster.api_gateway;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API Gateway", version = "1.0", description = "Documentation API Gateway v1.0"))
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}


	@Bean
	public WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> webServerFactoryCustomizer() {
		return factory -> factory.setPort(8080);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				// Rutas para user-service
				.route(r -> r.path("/user-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://user-service"))
				.route(r -> r.path("/api/auth/login").and().method(HttpMethod.POST).uri("lb://user-service"))
				.route(r -> r.path("/api/auth/register").and().method(HttpMethod.POST).uri("lb://user-service"))
				.route(r -> r.path("/api/typeofuser").and().method(HttpMethod.GET).uri("lb://user-service"))
				.route(r -> r.path("/api/typeofuser").and().method(HttpMethod.POST).uri("lb://user-service"))
				.route(r -> r.path("/api/typeofuser/{id}").and().method(HttpMethod.PUT).uri("lb://user-service"))
				.route(r -> r.path("/api/typeofuser/{id}").and().method(HttpMethod.DELETE).uri("lb://user-service"))
				.route(r -> r.path("/api/users").and().method(HttpMethod.GET).uri("lb://user-service"))
				.route(r -> r.path("/api/users").and().method(HttpMethod.POST).uri("lb://user-service"))
				.route(r -> r.path("/api/users/{id}").and().method(HttpMethod.PUT).uri("lb://user-service"))
				.route(r -> r.path("/api/users/{id}").and().method(HttpMethod.DELETE).uri("lb://user-service"))
				.route(r -> r.path("/api/users/{id}").and().method(HttpMethod.GET).uri("lb://user-service"))
				// Rutas para patient-service
				.route(r -> r.path("/patient-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients").and().method(HttpMethod.POST).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients").and().method(HttpMethod.GET).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/{id}").and().method(HttpMethod.GET).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/{id}").and().method(HttpMethod.PUT).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/{id}").and().method(HttpMethod.DELETE).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/dni/{dni}").and().method(HttpMethod.GET).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/gender/{gender}").and().method(HttpMethod.GET).uri("lb://patient-service"))
				.route(r -> r.path("/api/patients/age/{age}").and().method(HttpMethod.GET).uri("lb://patient-service"))
				// Rutas para iotdevice-service
				.route(r -> r.path("/iotdevice-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/typeDeviceIoT").and().method(HttpMethod.POST).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/typeDeviceIoT").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/typeDeviceIoT/{id}").and().method(HttpMethod.PUT).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/typeDeviceIoT/{id}").and().method(HttpMethod.DELETE).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/typeDeviceIoT/{id}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT").and().method(HttpMethod.POST).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/{id}").and().method(HttpMethod.PUT).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/{id}").and().method(HttpMethod.DELETE).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/{id}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/assigned/{assigned}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/type/{typeDeviceIoTId}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/deviceIoT/serial/{serialCode}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				// Rutas para iotdata-service
				.route(r -> r.path("/api/iotdata").and().method(HttpMethod.POST).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata/{id}").and().method(HttpMethod.PUT).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata/{id}").and().method(HttpMethod.DELETE).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata/{id}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata/patient/{patientId}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				.route(r -> r.path("/api/iotdata/serial/{serialNumber}").and().method(HttpMethod.GET).uri("lb://iotdevice-service"))
				// Rutas para measurement-service
				.route(r -> r.path("/measurement-service/v3/api-docs").and().method(HttpMethod.GET).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements").and().method(HttpMethod.POST).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements").and().method(HttpMethod.GET).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements/{id}").and().method(HttpMethod.PUT).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements/{id}").and().method(HttpMethod.DELETE).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements/{id}").and().method(HttpMethod.GET).uri("lb://measurement-service"))
				.route(r -> r.path("/api/measurements/patient/{patientId}").and().method(HttpMethod.GET).uri("lb://measurement-service"))
				.build();
	}
}

package pe.edu.upc.sellmaster.api_gateway;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
                .csrf(ServerHttpSecurity.CsrfSpec::disable) // Deshabilita CSRF
                .authorizeExchange(exchanges -> exchanges
                        .pathMatchers(
                                //"/**",
                                "/api/**",
                                "/api/iotdata/**",
                                "/v3/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html",
                                "/swagger-resources/**",
                                "/webjars/**",
                                "/iotdevice-service/v3/api-docs",
                                "/user-service/v3/api-docs",
                                "/patient-service/v3/api-docs",
                                "/measurement-service/v3/api-docs"
                        ).permitAll() // Permitir acceso a Swagger y API docs
                        .anyExchange().authenticated() // Requerir autenticación para cualquier otra ruta
                ); // Configura autenticación básica

        return http.build();
    }
}

package org.example.config;


import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI shopApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("SurfSkate Shop API")
                        .description("REST API длlя магазина товаров SURF / SKATE")
                        .contact(new Contact()
                                .name("Developer")
                                .email("developer@example.com"))
                        .version("1.0.0"));
    }
}

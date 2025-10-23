package com.example.mssinaramongo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customopenApi() {
        return new OpenAPI()
                .info(new Info()
                        .title("ms-sinara-mongo")
                        .version("1.0")
                        .description("API conectada ao MongoDB para o Sistema mobile e web do Sinara.")
                        .termsOfService("https://www.exemplo.com/terms")
                        .contact(new Contact()
                                .name("Equipe de desenvolvimento - Sinara")
                                .email("contato@exemplo.com")
                                .url("https://www.exemplo.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org"))
                        .extensions(Map.of("produces", List.of("application/json")))
                );
    }
}
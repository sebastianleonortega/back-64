package com.base64.gamesback.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    /**
     * Bean para proporcionar una configuración personalizada de OpenAPI.
     *
     * @return OpenAPI: La configuración personalizada de OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI(){
        return new OpenAPI()
                .info(new Info().title("Factura Electronica")
                        .description("Api para la gestión y emisión de facturas electrónicas")
                        .version("v0.0.1")
                        .termsOfService("")
                );
    }

}
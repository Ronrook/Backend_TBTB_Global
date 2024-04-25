package com.tbtbglobal.pruebatecnica.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuración Swagger para la generación de documentación de la API REST
 **/
@Configuration
public class SwaggerConfig {
    /**
     * Indica que el retorno es un bean disponible para el contenedor beans,
     * Spring lo inyectara y generará una web con la documentación
     **/
    @Bean
    public OpenAPI apiDetails() {

        return new OpenAPI()
                .info(new Info()
                .title("TBTB - Prueba técnica")
                .description("Aplicación para llevar un registro de los pacientes, medicos, citas y medicamentos.")
                .version("1.0.0"));
    }
}
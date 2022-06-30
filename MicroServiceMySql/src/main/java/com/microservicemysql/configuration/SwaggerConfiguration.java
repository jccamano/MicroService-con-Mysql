package com.microservicemysql.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfiguration {
	
	@Bean
    public OpenAPI customOpenAPI(@Value("1.0.0") String appVersion) {
        return new OpenAPI().components(new Components().addSecuritySchemes("bearer-key",
                new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT"))).info(new Info().title("MicroService MySql")
                .version(appVersion).license(new License().name("Apache 2.0").url("http://springdoc.org")).contact(new Contact().name("Juan Carlos Camaño").url("").email("jccamanoh@eafit.edu.co")));
    }

}

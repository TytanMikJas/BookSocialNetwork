package com.tytan.book.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "MikJasTytan",
                        email = "mikjas02@gmail.com",
                        url = "https://github.com/TytanMikJas"
                ),
                title = "Book Network API",
                version = "1.0",
                description = "Book Network API Documentation",
                license = @License(
                        name = "License",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                ),
                termsOfService = "http://swagger.io/terms/"
        ),
        servers = {
                @Server(
                        url = "http://localhost:8080/api/v1",
                        description = "Local server"
                ),
                @Server(
                        url = "https://book-network.tytan.com",
                        description = "Production server"
                )
        },
        security = {
                @SecurityRequirement(name = "bearerAuth"),
        }
)
@SecurityScheme(
        name = "bearerAuth",
        description = "JWT auth desc",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class OpenApiConfig {
}

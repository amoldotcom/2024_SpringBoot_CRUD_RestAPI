package com.example.SpringBootMongoDBRestAPI.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(
        info = @Info(
                title = "Task API",
                description = "Doing CRUD Operations",
                summary = "This task-api will add, delete, create & update tasks",
                version = "v1"
        )
)
public class OpenApiConfig {
}

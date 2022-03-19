package com.kotlin.study.util

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class SwaggerConfig {

    @Bean
    fun springOpenAPI(): OpenAPI? {
        return OpenAPI()
            .info(
                Info().title("Bank API")
                    .description("Spring Bank Application")
                    .version("v0.0.1")
            )
    }

}
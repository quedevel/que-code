package com.quecode.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@EnableWebMvc
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket swagger(){
        return new Docket(DocumentationType.OAS_30)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build().apiInfo(apiInfo());

    }

    private ApiInfo apiInfo() {
        String description = "Qua Swagger API TEST";
        return new ApiInfoBuilder()
                .title("Qua Swagger API")
                .description(description)
                .version("1.0")
                .build();
    }
}

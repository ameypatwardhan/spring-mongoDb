package com.example.springmongodb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableSwagger2
@Configuration
public class SwaggerConfig {

    @Bean
    public Docket productApi()
    {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.example.springmongodb")).paths(
                regex("/book.*")).build().apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        Contact contact = new Contact(
                "xyz",
                "xyz@xyz.com",
                "xyz@xyz.com"
        );
        ApiInfo apiInfo = new ApiInfo("Spring Boot Swagger Example API",
                "Spring Boot Swagger Example API for SpringBoot MongoDb connection",
                "1.0", "Term of Service",contact.toString(),"temp license","licUrl@url.com" );

        return apiInfo;
    }
}

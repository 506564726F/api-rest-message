package com.soaint.api.rest.message.config;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Autowired
  ApplicationProperties applicationProperties;

  @Bean
  public Docket apiPerson() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors
            .basePackage(applicationProperties.getSwaggerBasePackage()))
        .paths(PathSelectors.any())
        .build()
        .apiInfo(getInfo());
  }

  private ApiInfo getInfo() {
    return new ApiInfo(
        "API documentation SOAint",
        "Methods and information needed from the platform management API.",
        "1.0",
        "© Pedro Barreto",
        new springfox.documentation.service.Contact("Pedro Barreto", "https://www.filosofofrustrado.com",
            "pedrobarreto1213@gmail.com"),
        "All rights reserved to Pedro",
        "https://www.filosofofrustrado.com",
        Collections.emptyList()
    );
  }
}
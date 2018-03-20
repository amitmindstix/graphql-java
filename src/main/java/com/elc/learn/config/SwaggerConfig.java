/* ***************************************************************************
 * Copyright 2018 Mindstix, Inc.  All rights reserved.
 * -- Mindstix Confidential
 * ***************************************************************************/

package com.elc.learn.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@ComponentScan("com.elc.learn")
public class SwaggerConfig {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
                        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.cloud")))
                        .apis(Predicates.not(RequestHandlerSelectors.basePackage("org.springframework.data.rest.webmvc")))
                        .apis(Predicates.not(RequestHandlerSelectors.basePackage("com.graphql-java")))
                .paths(Predicates.not(PathSelectors.regex("/error")))
                .build()
                .apiInfo(apiInfo());
    }
    

    private ApiInfo apiInfo() {
        String description = "REST example";
        return new ApiInfoBuilder()
                .title("REST example vNext")
                .description(description)
                .termsOfServiceUrl("github")
                .license("Mindstix Labs")
                .licenseUrl("")
                .version("1.1")
 //               .contact(new Contact("siamak"))
                .build();
    }

}
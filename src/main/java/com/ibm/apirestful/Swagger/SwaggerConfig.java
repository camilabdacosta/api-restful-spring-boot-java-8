package com.ibm.apirestful.Swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket (DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ibm.apirestful")).paths(PathSelectors.any()).build()
                .apiInfo(apiInfo());
    }
    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("com.ibm.apirestful.Swagger API")
                .descripition("Documentação da API de acesso aos endpoints com com.ibm.apirestful.Swagger").version("1,0").build();

    }
}

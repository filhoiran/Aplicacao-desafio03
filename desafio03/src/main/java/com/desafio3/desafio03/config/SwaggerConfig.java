package com.desafio3.desafio03.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.web.bind.annotation.RequestMethod;

import com.google.common.net.HttpHeaders;

//import antlr.collections.List;
//import io.swagger.annotations.AuthorizationScope;
import io.swagger.models.auth.In;
import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.AuthorizationCodeGrantBuilder;
//import springfox.documentation.builders.OAuthBuilder;
//import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.builders.ResponseMessageBuilder;
//import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
//import springfox.documentation.service.GrantType;
//import springfox.documentation.service.ResponseMessage;
//import springfox.documentation.service.SecurityReference;
//import springfox.documentation.service.SecurityScheme;
//import springfox.documentation.service.TokenEndpoint;
//import springfox.documentation.service.TokenRequestEndpoint;
//import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger.web.SecurityConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

//import java.util.ArrayList;
import java.util.Arrays;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
    public Docket pessoaApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.desafio3.desafio03"))
                .paths(regex("/api.*"))
                .build()
        		.apiInfo(metaInfo())
 		        .securitySchemes(Arrays.asList(new ApiKey("Token Access", HttpHeaders.AUTHORIZATION, In.HEADER.name())));
//        		.securityContexts(Arrays.asList(securityContext()))
//              .useDefaultResponseMessages(false)
		/*
		 * .globalResponseMessage(RequestMethod.GET, newArrayList(new
		 * ResponseMessageBuilder() .code(500) .message("500 message")
		 * .responseModel(new ModelRef("Error")) .build(), new ResponseMessageBuilder()
		 * .code(403) .message("Forbidden!") .build() ))
		 */
	}

	private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
        	.title("Ibyte Spring Boot API REST")
        	.description("Aplicação para gerenciar informações dos colaboradores da empresa")
        	.version("1.0.0")
        	.license("Terms of Service - Apache License Version 2.0")
            .licenseUrl("http://5e61af346f5c7900149bc5b3.mockapi.io/desafio03/employer")
            .contact(new Contact("Jose Iran Costa Filho - em003157", "TIC", " jose.iran_@hotmail.com"))
            .build();
    }
	
	/*
	 * private SecurityContext securityContext() { return SecurityContext.builder()
	 * .securityReferences(defaultAuth()) .forPaths(PathSelectors.ant("/pessoa/**"))
	 * .build(); }
	 * 
	 * List<SecurityReference> defaultAuth() { AuthorizationScope authorizationScope
	 * = new AuthorizationScope("ADMIN", "accessEverything"); AuthorizationScope[]
	 * authorizationScopes = new AuthorizationScope[1]; authorizationScopes[0] =
	 * authorizationScope; return Arrays.asList( new
	 * SecurityReference("Token Access", authorizationScopes)); }
	 */
    
}

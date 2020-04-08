package com.infosys.firstinfyproject;

import java.util.Collections;

import org.apache.commons.codec.binary.Base64;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class App {
	public static void main(String[] args) {
		// Base 64 encoding decoding example below:
		byte[] encodeBase64 = Base64.encodeBase64("Sujay".getBytes());
		System.out.println("Encoded String: " + new String(encodeBase64));
		byte[] decodeBase64 = Base64.decodeBase64(encodeBase64);
		System.out.println("Decoded String: " + new String(decodeBase64));
		// start app as boot application...
		SpringApplication.run(App.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		return new Docket(DocumentationType.SWAGGER_2).select().paths(PathSelectors.ant("/orders/*"))
				.apis(RequestHandlerSelectors.basePackage("com.infosys.firstinfyproject")).build().apiInfo(apiInfo());
	}

	private ApiInfo apiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfo("InfyFirstApp", "For CnD Enablement training", "1.0", "NoTermsAndCondition",
				new Contact("Sujay Agrawal", "http://sujayagrawal.github.io", "agrawalsujay11@gmail.com"),
				"Public License", "http://sujayagrawal.github.io", Collections.emptyList());
	}
}

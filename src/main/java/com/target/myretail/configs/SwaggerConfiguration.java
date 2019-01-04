package com.target.myretail.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.google.common.base.Predicate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {

	private final Logger logger = LoggerFactory.getLogger(SwaggerConfiguration.class);

	@Bean
	public Docket filterApi() {
		logger.debug("Docket created for swagger documentation.");
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.target.myretail.controllers")).paths(apiPaths()).build()
				.apiInfo(metaData());
	}

	private Predicate<String> apiPaths() {
		return PathSelectors.regex("/products.*");
	}

	private ApiInfo metaData() {
		logger.info("Metadata created for swagger documentation.");
		ApiInfo apiInfo = new ApiInfo("Product Service REST API", "REST API for Product Information", "1.0",
				"Terms of service", new Contact("Phani Kumar Yadavilli ", "", "phanikumaryadavilli@gmail.com"), "", "");
		return apiInfo;
	}
}

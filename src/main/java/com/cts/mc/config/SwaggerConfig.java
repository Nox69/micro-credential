package com.cts.mc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.cts.mc"))
				.paths(PathSelectors.any()).build().apiInfo(apiEndPointsInfo()).ignoredParameterTypes(ApiIgnore.class);
	}

	private ApiInfo apiEndPointsInfo() {
		return new ApiInfoBuilder().title("Micro-Credential")
				.description("Spting Boot Rest API ready to be deployed in AWS")
				.contact(new Contact("Bharat", "", "bharatch@yahoo.in")).version("0.1.0").build();

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/swagger-ui.html**")
				.addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Override
	public void addViewControllers(ViewControllerRegistry controllerRegistry) {
		controllerRegistry.addRedirectViewController("/v2/api-docs", "/v2/api-docs");
		controllerRegistry.addRedirectViewController("/swagger-resources/configuration/security",
				"/swagger-resources/configuration/security");
		controllerRegistry.addRedirectViewController("/swagger-resources/configuration/ui",
				"/swagger-resources/configuration/ui");
		controllerRegistry.addRedirectViewController("/swagger-resources", "/swagger-resources");

	}
}

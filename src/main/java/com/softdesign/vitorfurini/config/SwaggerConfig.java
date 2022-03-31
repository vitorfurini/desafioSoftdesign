package com.softdesign.vitorfurini.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.softdesign.vitorfurini.constants.GlobalConstants.DEV_EMAIL;
import static com.softdesign.vitorfurini.constants.GlobalConstants.DEV_GITHUB;
import static com.softdesign.vitorfurini.constants.GlobalConstants.DEV_NAME;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket softDesignApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.softdesign.vitorfurini"))
                .build();
    }

    private ApiInfo getApiInfo() {
        return new ApiInfoBuilder()
                .title("Pessoa API REST")
                .contact(new Contact(DEV_NAME, DEV_GITHUB, DEV_EMAIL))
                .description("API desenvolvida para fins de Teste avaliativo")
                .version("1.0.0")
                .build();
    }

}

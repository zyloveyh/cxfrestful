package com.zy.cxfrestful;

import com.knime.enterprise.server.rest.impl.v4.admin.roles.AllRolesImpl;
import com.knime.enterprise.server.rest.impl.v4.admin.roles.RoleImpl;
import com.zy.cxfrestful.service.demo1.HelloServiceImpl1;
import com.zy.cxfrestful.service.demo2.HelloServiceImpl2;
import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.feature.LoggingFeature;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CxfrestfulApplication {

    @Autowired
    private Bus bus;

    public static void main(String[] args) {
        SpringApplication.run(CxfrestfulApplication.class, args);
    }

    @Bean
    public Server rsServer() {
        JAXRSServerFactoryBean endpoint = new JAXRSServerFactoryBean();
        endpoint.setBus(bus);
        endpoint.setServiceBeans(Arrays.<Object>asList(new AllRolesImpl() ,new RoleImpl() ));
        endpoint.setAddress("/");
//        endpoint.setFeatures(Arrays.asList(createOpenApiFeature(), new LoggingFeature()));
        return endpoint.create();
    }

   /* @Bean
    public OpenApiFeature createOpenApiFeature() {
        final OpenApiFeature openApiFeature = new OpenApiFeature();
        openApiFeature.setPrettyPrint(true);
        openApiFeature.setTitle("Spring Boot CXF REST Application");
        openApiFeature.setContactName("The Apache CXF team");
        openApiFeature.setDescription("This sample project demonstrates how to use CXF JAX-RS services"
                + " with Spring Boot. This demo has two JAX-RS class resources being"
                + " deployed in a single JAX-RS endpoint.");
        openApiFeature.setVersion("1.0.0");
        openApiFeature.setSwaggerUiConfig(
                new SwaggerUiConfig()
                        .url("/services/helloservice/openapi.json"));
        return openApiFeature;
    }*/

}

package com.zy.cxfrestful.service.demo2;

import com.zy.cxfrestful.service.api.HelloService;

import javax.ws.rs.Path;

@Path("/sayHello2")
public class HelloServiceImpl2 implements HelloService {

    public String sayHello(String a) {
        return "Hello2 " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}
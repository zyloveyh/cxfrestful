package com.zy.cxfrestful.service.demo1;


import com.zy.cxfrestful.service.api.HelloService;

public class HelloServiceImpl1 implements HelloService {

    public String sayHello(String a) {
        return "Hello " + a + ", Welcome to CXF RS Spring Boot World!!!";
    }

}
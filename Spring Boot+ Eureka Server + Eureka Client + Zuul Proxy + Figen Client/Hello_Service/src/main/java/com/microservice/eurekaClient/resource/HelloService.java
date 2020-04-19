package com.microservice.eurekaClient.resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/hello")
public class HelloService {
	
	@Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;
    
    @GetMapping(value ="/welcome")
	public String welcome() {
		return "Welcome to: "+appName+" running with port no: "+portNumber;
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/sayHello")
	public String sayHello() {
		return "Hello this is from: "+appName+" running with port no: "+portNumber;
	}
	
}//class

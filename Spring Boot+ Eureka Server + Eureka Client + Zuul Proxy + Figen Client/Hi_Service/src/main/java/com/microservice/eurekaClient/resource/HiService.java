package com.microservice.eurekaClient.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.microservice.eurekaClient.client.HelloClient;

@RestController
@RequestMapping(value ="/hi")
public class HiService {
	
	@Autowired
	private HelloClient helloClient;
	
	@Value("${spring.application.name}")
    private String appName;

    @Value("${server.port}")
    private String portNumber;
	
	@RequestMapping(method = RequestMethod.GET,value = "/welcome")
	public String welcome() {
		return "Welcome to: "+appName+" running with port no: "+portNumber;
	}//welcome()
	
	@RequestMapping(method = RequestMethod.GET,value = "/sayHi")
	public String sayHi() {
		return "Hi this is from: "+appName+" running with port no: "+portNumber;
	}//sayHi()
	
	@RequestMapping(method = RequestMethod.GET,value = "/callToHello")
	public String callToHello() {
		//invoke hello service
		String helloMsg=helloClient.invokeHelloService();
		return helloMsg;
	}//callToHello()
	
}//class

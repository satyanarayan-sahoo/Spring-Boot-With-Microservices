package com.microservice.eurekaClient.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Configuration
@FeignClient(value = "hello-service")
public interface HelloClient {
	
	@RequestMapping(method = RequestMethod.GET,value = "/hello/sayHello")
	public String invokeHelloService();
	
}

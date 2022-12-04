package com.example.testcasedemo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.testcasedemo.controller.GreetingOperation;
import com.example.testcasedemo.service.GreetingService;

@SpringBootTest // simulate spring boot application to execute in compile time as extact running environment/situation
//for example controller + service will be create in spring context
class TestcasedemoApplicationTests {

	@Autowired
	GreetingOperation greetingOperation;

	@Autowired
	GreetingService greetingService;

	@Test // respresent this method will be run automatically
	void contextLoads() {
		//mockito, Junit 5
		Assertions.assertThat(greetingOperation).isNotNull();
		Assertions.assertThat(greetingService).isNotNull();
	}

	

}

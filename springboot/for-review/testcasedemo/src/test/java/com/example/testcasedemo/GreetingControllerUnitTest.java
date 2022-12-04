package com.example.testcasedemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.example.testcasedemo.controller.GreetingOperation;
import com.example.testcasedemo.controller.impl.GreetingController;
import com.example.testcasedemo.service.GreetingService;
import com.example.testcasedemo.service.impl.GreetingServiceHolder;

@ExtendWith(SpringExtension.class) //Junit 5: this class 帶來 @Mock @InjectMocks
public class GreetingControllerUnitTest {
  
  @Mock
  GreetingService greetingService;

  //fielf injection
  //因為controller入面有service,autowire唔到in here(no application),所以會用依個
  //this one, 用mock既service去autowire in injectmock既controller
  //problem!!:如果冇mock佢係唔會出error
  //@InjectMocks
  //private GreetingController greetingOperation;//同下面分別

  //Or
  //contructor injection, controller要有contructoro
  private GreetingOperation greetingOperation;
  //每行一個test case前,都要行beforeEach , better than inject mock
  @BeforeEach
  void setup(){
    greetingOperation = new GreetingController(greetingService); 
  }

  private void testGreeting(String input, String output){
    Mockito.when(greetingService.greeting()).thenReturn(input);

    String predict = output;
    String actual = greetingOperation.greeting();

    Assertions.assertThat(actual).isEqualTo(predict);
  }

  private void testWelcome(String ControllerOutput,String serviceInput, String serviceOutput){
    Mockito.when(greetingService.welcome(serviceInput)).thenReturn(serviceOutput);
    String predict = ControllerOutput;
    String msg = greetingService.welcome(serviceInput);
    ResponseEntity<String> actual = ResponseEntity.ok().body(msg);

    
    Assertions.assertThat(actual).isEqualTo(predict);
  }

  @Test
  void testCases(){
    testGreeting("Hello world","Hello world");
  }


  

  
}

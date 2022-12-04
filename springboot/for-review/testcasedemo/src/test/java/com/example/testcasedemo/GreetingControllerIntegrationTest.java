package com.example.testcasedemo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.result.StatusResultMatchers;
import com.example.testcasedemo.service.GreetingService;

@WebMvcTest
//start spring context, but with controller related bean only
public class GreetingControllerIntegrationTest {
  
  @MockBean // create a new bean to spring context
  GreetingService greetingService;

  @Autowired 
  // Due to @MvcTest, the mocMvc Bean has been loaded to context
  MockMvc mockMvc;

  @Test
  @Disabled
  void testWebMvc () throws Exception{
    Mockito.when(greetingService.greeting()).thenReturn("Hello world");
    MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/api/v1/greeting");
    ResultActions response = mockMvc.perform(builder); // execute the call (call api) as if postman

    //check if the response is 200/OK
    StatusResultMatchers status = MockMvcResultMatchers.status();
    ResultMatcher statusOK = status.isOk(); //this is 200
    response.andExpect(statusOK);

    //check content
    ContentResultMatchers content = MockMvcResultMatchers.content();
    ResultMatcher contentHelloWorld = content.string("hello world");
    response.andExpect(contentHelloWorld);
  }

  @Test
  void testMvc2() throws Exception{
    Mockito.when(greetingService.greeting()).thenReturn("hello world");
    mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/greeting")) // request url
          .andExpect(MockMvcResultMatchers.status().isOk()) // check status == 200
          .andExpect(MockMvcResultMatchers.content().string("hello world")); //check content == "hello world"
  }
}

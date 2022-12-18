package com.crypto.callapipolygon.problem;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.crypto.callapipolygon.response.ApiResponse;


@ControllerAdvice
public class ControllerHandler {
  @ExceptionHandler({NullPointerException.class})
  public <T> ResponseEntity<ApiResponse<T>> npeHandler(){
    return ResponseEntity.badRequest().body(null);
  }
}

package com.crypto_backend.polygon_call.problem;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crypto_backend.polygon_call.problem.self_define_exception.DeserializeFailure;
import com.crypto_backend.polygon_call.response.ApiResponse;

@RestControllerAdvice
public class ControllerHandler {

  @ExceptionHandler({DeserializeFailure.class})
  public <T> ResponseEntity<ApiResponse<T>> deserializeFailureHandler(){
    return ResponseEntity.badRequest().body(new ApiResponse<T>(30000, "failure to deserialize the json from the third party api: this may caused by:\n 1.changing the structure of url, require another mapper", null));
  }

  @ExceptionHandler({NullPointerException.class})
  public <T> ResponseEntity<ApiResponse<T>> npeHandler(){
    return ResponseEntity.badRequest().body(new ApiResponse<T>(20000, "null pointer exception", null));
  }

  @ExceptionHandler({ClassCastException.class})
  public <T> ResponseEntity<ApiResponse<T>> classCastExceptionHandler(){
    return ResponseEntity.badRequest().body(new ApiResponse<T>(20001, "class cast exception", null));
  }

  @ExceptionHandler({IllegalStateException.class})
  public <T> ResponseEntity<ApiResponse<T>> illegalStateExceptionHandler(){
    return ResponseEntity.badRequest().body(new ApiResponse<T>(20002, "illegal state exception", null));
  }
}

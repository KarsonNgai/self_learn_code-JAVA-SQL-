package com.vtxlab.demo.forumpost.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.vtxlab.demo.forumpost.exception.response.ContentLengthUnavailable;
import com.vtxlab.demo.forumpost.exception.response.KeyExistException;
import com.vtxlab.demo.forumpost.exception.response.OutOfIndex;
import com.vtxlab.demo.forumpost.exception.response.TitleLengthUnavailable;
import com.vtxlab.demo.forumpost.responsebody.ApiResponse;

@ControllerAdvice
public class GobalExceptionHandler {

  @ExceptionHandler({TitleLengthUnavailable.class})
  public <T> ResponseEntity<ApiResponse<T>> handleTitleLength(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(15000, "Title Length unavailable", null));
  }

  @ExceptionHandler({ContentLengthUnavailable.class})
  public <T> ResponseEntity<ApiResponse<T>> handleContentLength(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(15001,"Content Length unavaiable", null));
  }

  @ExceptionHandler({OutOfIndex.class})
  public <T> ResponseEntity<ApiResponse<T>> handleOutOfIndexException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(20000,"Out of Index",null));
  }
  
  @ExceptionHandler({KeyExistException.class})
  public <T> ResponseEntity<ApiResponse<T>> handleKeyExistException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(13001,"Key already exist",null));
  }

  @ExceptionHandler({NullPointerException.class})
  public <T> ResponseEntity<ApiResponse<T>> handleNpeException(){
    return ResponseEntity.badRequest().body(new ApiResponse<>(13002,"Null pointer",null));
  }

  @ExceptionHandler({Exception.class})
  public <T> ResponseEntity<ApiResponse<T>> internalServerError(){
    return ResponseEntity.internalServerError().body(null);
  }
}

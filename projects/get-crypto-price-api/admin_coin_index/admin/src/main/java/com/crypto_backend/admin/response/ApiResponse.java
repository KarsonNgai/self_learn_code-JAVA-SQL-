package com.crypto_backend.admin.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse <T>{
  private int code;
  private String description;
  private T data;

  public ApiResponse(T data){
    this.code = 200;
    this.description = "success";
    this.data = data;
  }

}

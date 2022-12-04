package com.vtxlab.demo.forumpost.responsebody;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse<T> {
  private int code;
  
  private String message;

  T data;
}

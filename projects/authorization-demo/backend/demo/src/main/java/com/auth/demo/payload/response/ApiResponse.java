package com.auth.demo.payload.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse <T>{
    private Long statusCode = 200L;
    private T data;

    public ApiResponse(T data){
        this.data = data;
    }
}

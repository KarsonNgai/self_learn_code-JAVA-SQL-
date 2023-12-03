package com.saving_management.app.pojo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    int statusCode = 200;
    T data;
    String message;

    public ApiResponse(T data, String message){
        this.data = data;
        this.message = message;
    }

    public ApiResponse(String message){
        this.message = message;
    }
}

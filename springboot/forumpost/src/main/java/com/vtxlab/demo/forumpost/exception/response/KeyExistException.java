package com.vtxlab.demo.forumpost.exception.response;

import com.vtxlab.demo.forumpost.exception.CustomResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class KeyExistException extends CustomResponse{
  
  public KeyExistException(int code, String message){
    super(code,message);
  }
}

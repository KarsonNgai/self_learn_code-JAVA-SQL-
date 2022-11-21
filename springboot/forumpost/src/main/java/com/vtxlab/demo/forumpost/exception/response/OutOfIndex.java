package com.vtxlab.demo.forumpost.exception.response;

import com.vtxlab.demo.forumpost.exception.CustomResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class OutOfIndex extends CustomResponse{

  public OutOfIndex(int code, String message){
    super(code,message);
  }
}

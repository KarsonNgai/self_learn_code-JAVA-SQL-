package com.vtxlab.demo.forumpost.exception.response;

import com.vtxlab.demo.forumpost.exception.CustomResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class TitleLengthUnavailable extends CustomResponse{
  
  public TitleLengthUnavailable(int code, String message){
    super(code,message);
  }

}



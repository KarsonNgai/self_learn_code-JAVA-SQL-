package com.vtxlab.demo.forumpost.exception.response;

import com.vtxlab.demo.forumpost.exception.CustomResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ContentLengthUnavailable extends CustomResponse{
  
  public ContentLengthUnavailable(int code, String message){
    super(code,message);
  }

}

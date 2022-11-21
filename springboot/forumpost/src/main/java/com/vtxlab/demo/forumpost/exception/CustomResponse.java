package com.vtxlab.demo.forumpost.exception;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class CustomResponse extends Exception{
  public int code;

  public CustomResponse(int code,String msg){
    super(msg);
    this.code=code;
  }
}

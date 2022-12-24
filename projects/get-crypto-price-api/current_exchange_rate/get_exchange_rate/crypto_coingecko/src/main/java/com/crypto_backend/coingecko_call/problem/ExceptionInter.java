package com.crypto_backend.coingecko_call.problem;

public class ExceptionInter extends RuntimeException{

    public ExceptionInter(){
        super();
    }

    public ExceptionInter(String msg){
        super(msg);
    }

}

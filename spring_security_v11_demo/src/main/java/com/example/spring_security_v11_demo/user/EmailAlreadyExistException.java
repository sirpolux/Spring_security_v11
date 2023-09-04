package com.example.spring_security_v11_demo.user;

public class EmailAlreadyExistException extends  RuntimeException{
    public EmailAlreadyExistException(String msg){
        super(msg);
    }
}

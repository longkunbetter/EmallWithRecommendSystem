package com.emall.system.exception;

public class ServiceException extends RuntimeException{
    public ServiceException(String cause){
        super("业务异常:" + cause);
    }
}

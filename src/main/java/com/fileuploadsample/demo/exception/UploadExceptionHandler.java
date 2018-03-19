package com.fileuploadsample.demo.exception;

public class UploadExceptionHandler extends RuntimeException {

    public UploadExceptionHandler(String msg){
        super(msg);
    }

    public UploadExceptionHandler(String msg, Throwable throwable){
        super(msg, throwable);
    }
}

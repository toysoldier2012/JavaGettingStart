package com.xiaoyu.exception;

public class AnException extends RuntimeException{
    public AnException() {
        super();
    }

    public AnException(String message) {
        super(message);
    }

    public AnException(String message, Throwable cause) {
        super(message, cause);
    }

    public AnException(Throwable cause) {
        super(cause);
    }

    protected AnException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

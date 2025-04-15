package com.ammdev.financialaggregator.exception;

public class AuthenticationException extends BaseException{

    private static final String message = "AUTHENTICATION_EXCEPTION";

    public AuthenticationException(Integer code, String detail) {
        super(code, message, detail);
    }
}

package com.ammdev.financialaggregator.exception;

public class UserException  extends BaseException {

    private static final Integer code = 400;
    private static final String message = "USER_EXCEPTION";

    public UserException(String detail) {
        super(code, message, detail);
    }
}

package com.ammdev.FinancialAggregator.exception;

public abstract class BaseException extends RuntimeException  {

    protected String message;
    protected Integer code;
    protected String detail;

    public BaseException(Integer code, String message, String detail) {
        super(message);
        this.code = code;
        this.message = message;
        this.detail = detail;
    }
}

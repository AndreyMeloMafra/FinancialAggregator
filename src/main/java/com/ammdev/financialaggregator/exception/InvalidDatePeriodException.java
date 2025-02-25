package com.ammdev.financialaggregator.exception;

public class InvalidDatePeriodException extends BaseException {

    private static final Integer code = 400;
    private static final String message = "INVALID_DATE_PERIOD";

    public InvalidDatePeriodException(String detail) {
        super(code, message, detail);
    }
}

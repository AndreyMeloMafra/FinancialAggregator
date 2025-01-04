package com.ammdev.FinancialAggregator.exception;

public class InvalidStringDateException extends BaseException {

    private static final Integer code = 400;
    private static final String message = "INVALID_STRING_DATE";

    public InvalidStringDateException(String description) {
        super(code, message, description);
    }
}

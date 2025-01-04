package com.ammdev.FinancialAggregator.exception;

public class InvalidDatePeriodException extends BaseException {

    private static final Integer code = 400;
    private static final String message = "INVALID_DATE_PERIOD";

    public InvalidDatePeriodException(String detail) {
        super(code, message, detail);
    }
}

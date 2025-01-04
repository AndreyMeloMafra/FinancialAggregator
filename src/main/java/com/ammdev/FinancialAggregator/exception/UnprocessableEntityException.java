package com.ammdev.FinancialAggregator.exception;

public class UnprocessableEntityException extends BaseException {

    private static final Integer code = 422;
    private static final String message = "UNPROCESSABLE_ENTITY";

    public UnprocessableEntityException(String detail) {
        super(code, message, detail);
    }
}

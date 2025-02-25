package com.ammdev.financialaggregator.exception;

public class InvalidMonetaryValueException extends BaseException {

    private static final Integer code = 400;
    private static final String message = "INVALID_MONETARY_VALUE";

    public InvalidMonetaryValueException(String detail) {
        super(code, message, detail);
    }
}

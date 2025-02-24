package com.ammdev.FinancialAggregator.exception;

import com.ammdev.FinancialAggregator.domain.Error;
import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException  {

    protected Error error;

    public BaseException(Integer code, String message, String detail) {
        super(message);
        error = new Error(code, message, detail);
    }
}

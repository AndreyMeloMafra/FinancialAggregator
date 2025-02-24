package com.ammdev.FinancialAggregator.config;

import com.ammdev.FinancialAggregator.domain.Error;
import com.ammdev.FinancialAggregator.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(exception = BaseException.class)
    public Error sendError(BaseException baseException) {
        return baseException.getError();
    }
}

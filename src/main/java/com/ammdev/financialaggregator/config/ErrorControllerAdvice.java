package com.ammdev.financialaggregator.config;

import com.ammdev.financialaggregator.domain.Error;
import com.ammdev.financialaggregator.exception.BaseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(exception = BaseException.class)
    public Error sendError(BaseException baseException) {
        return baseException.getError();
    }
}

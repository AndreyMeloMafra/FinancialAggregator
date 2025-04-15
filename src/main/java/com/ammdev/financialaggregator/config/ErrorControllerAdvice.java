package com.ammdev.financialaggregator.config;

import com.ammdev.financialaggregator.domain.Error;
import com.ammdev.financialaggregator.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorControllerAdvice {

    @ExceptionHandler(exception = BaseException.class)
    public Error sendError(BaseException baseException) {
        return baseException.getError();
    }

    @ExceptionHandler(exception = RuntimeException.class)
    public Error sendRuntimeError(RuntimeException runtimeException) {
        return new Error(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),runtimeException.getMessage());
    }
}

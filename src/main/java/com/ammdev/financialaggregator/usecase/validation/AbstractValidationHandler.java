package com.ammdev.financialaggregator.usecase.validation;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.exception.UnprocessableEntityException;

import java.util.List;

public abstract class AbstractValidationHandler {

    protected AbstractValidationHandler next;

    public AbstractValidationHandler setNext(AbstractValidationHandler next) {
        this.next = next;
        return next;
    }

    public void validate(List<Cost> costs) {
        if (!doValidate(costs)) {
            throw new UnprocessableEntityException(getErrorMessage());
        }

        if (next != null) {
            next.validate(costs);
        }
    }

    protected abstract boolean doValidate(List<Cost> costs);
    protected abstract String getErrorMessage();
}
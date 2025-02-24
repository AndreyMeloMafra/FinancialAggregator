package com.ammdev.FinancialAggregator.usecase.validation;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.exception.UnprocessableEntityException;

public abstract class AbstractValidationHandler {

    protected AbstractValidationHandler next;

    public AbstractValidationHandler setNext(AbstractValidationHandler next) {
        this.next = next;
        return next;
    }

    public void validate(Cost cost) {
        if (!doValidate(cost)) {
            throw new UnprocessableEntityException(getErrorMessage());
        }

        if (next != null) {
            next.validate(cost);
        }
    }

    protected abstract boolean doValidate(Cost cost);
    protected abstract String getErrorMessage();
}
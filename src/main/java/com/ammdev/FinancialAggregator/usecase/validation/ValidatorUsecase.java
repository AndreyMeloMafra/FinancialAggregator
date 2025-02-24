package com.ammdev.FinancialAggregator.usecase.validation;

import com.ammdev.FinancialAggregator.domain.Cost;
import org.springframework.stereotype.Service;

@Service
public class ValidatorUsecase {

    private final AbstractValidationHandler validationChain;

    public ValidatorUsecase(ValidationJakartaHandler validationJakartaHandler,
                            ValidateInstalmentHandler validateInstalmentHandler) {
        this.validationChain = validationJakartaHandler;
        validationJakartaHandler.setNext(validateInstalmentHandler);
    }

    public void validate(Cost cost) {
        validationChain.validate(cost);
    }
}
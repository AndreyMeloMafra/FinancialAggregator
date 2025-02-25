package com.ammdev.financialaggregator.usecase.validation;

import com.ammdev.financialaggregator.domain.Cost;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValidatorUsecase {

    private final AbstractValidationHandler validationChain;

    public ValidatorUsecase(ValidationJakartaHandler validationJakartaHandler,
                            ValidateInstalmentHandler validateInstalmentHandler) {
        this.validationChain = validationJakartaHandler;
        validationJakartaHandler.setNext(validateInstalmentHandler);
    }

    public void validate(List<Cost> costs) {
        validationChain.validate(costs);
    }
}
package com.ammdev.FinancialAggregator.usecase.validation;

import com.ammdev.FinancialAggregator.domain.Cost;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ValidationJakartaHandler extends AbstractValidationHandler {

    private final Validator validator;
    private final Set<ConstraintViolation<Cost>> violations;
    private final String format = "O campo %s: %s | ";

    public ValidationJakartaHandler() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        this.violations = new HashSet<>();
        this.validator = validatorFactory.getValidator();
    }

    @Override
    protected boolean doValidate(Cost cost) {
        this.violations.addAll(validator.validate(cost));
        return this.violations.isEmpty();
    }

    @Override
    protected String getErrorMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        this.violations.forEach(violation -> stringBuilder.append(getViolationFormatted(violation)));

        return stringBuilder.toString();
    }

    private String getViolationFormatted(ConstraintViolation<Cost> violation) {
        return String.format(format, violation.getPropertyPath(), violation.getMessage());
    }
}
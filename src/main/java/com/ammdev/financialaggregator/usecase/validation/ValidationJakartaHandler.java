package com.ammdev.financialaggregator.usecase.validation;

import com.ammdev.financialaggregator.domain.Cost;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ValidationJakartaHandler extends AbstractValidationHandler {

    private final Validator validator;
    private final Set<ConstraintViolation<Cost>> violations;

    public ValidationJakartaHandler() {
        ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        this.violations = new HashSet<>();
        this.validator = validatorFactory.getValidator();
    }

    @Override
    protected boolean doValidate(List<Cost> costs) {
        for (Cost cost : costs) {
            Set<ConstraintViolation<Cost>> costViolations = validator.validate(cost);
            this.violations.addAll(costViolations);
        }
        return this.violations.isEmpty();
    }

    @Override
    protected String getErrorMessage() {
        StringBuilder stringBuilder = new StringBuilder();

        this.violations.forEach(violation -> stringBuilder.append(getViolationFormatted(violation)));

        return stringBuilder.toString();
    }

    private String getViolationFormatted(ConstraintViolation<Cost> violation) {
        String format = "O campo %s: %s | ";
        return String.format(format, violation.getPropertyPath(), violation.getMessage());
    }
}
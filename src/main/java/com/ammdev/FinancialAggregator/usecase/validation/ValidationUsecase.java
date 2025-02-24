package com.ammdev.FinancialAggregator.usecase.validation;

import com.ammdev.FinancialAggregator.domain.Cost;

public interface ValidationUsecase {
    void validate(Cost cost);
}

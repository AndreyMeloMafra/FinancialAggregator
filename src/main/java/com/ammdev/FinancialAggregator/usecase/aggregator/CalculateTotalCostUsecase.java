package com.ammdev.FinancialAggregator.usecase.aggregator;

import com.ammdev.FinancialAggregator.domain.Cost;

import java.util.List;

public interface CalculateTotalCostUsecase {
    Double execute(List<Cost> costs);
}

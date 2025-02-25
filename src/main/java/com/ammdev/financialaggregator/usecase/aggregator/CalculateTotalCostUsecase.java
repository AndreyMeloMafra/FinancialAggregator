package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.Cost;

import java.util.List;

public interface CalculateTotalCostUsecase {
    Double execute(List<Cost> costs);
}

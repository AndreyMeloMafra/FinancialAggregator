package com.ammdev.FinancialAggregator.usecase.aggregator;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;
import com.ammdev.FinancialAggregator.domain.Cost;

import java.util.List;

public interface ClassifyCostUsecase {
    AggregatorResponse classifyCost(List<Cost> costs);
}

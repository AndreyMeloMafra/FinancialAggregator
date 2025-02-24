package com.ammdev.FinancialAggregator.usecase.aggregator;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;
import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.Period;

import java.util.List;

public interface AggregateCostUsecase {
    AggregatorResponse execute(List<Cost> costs, Period period);
}

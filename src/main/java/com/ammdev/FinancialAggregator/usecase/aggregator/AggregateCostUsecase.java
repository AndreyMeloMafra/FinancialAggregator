package com.ammdev.FinancialAggregator.usecase.aggregator;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;

import java.time.Period;

public interface AggregateCostUsecase {
    AggregatorResponse execute(String userId, Period period);
}

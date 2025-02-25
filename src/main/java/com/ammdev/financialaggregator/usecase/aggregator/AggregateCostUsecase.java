package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.AggregatorResponse;
import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.Period;

import java.util.List;

public interface AggregateCostUsecase {
    AggregatorResponse execute(List<Cost> costs, Period period);
}

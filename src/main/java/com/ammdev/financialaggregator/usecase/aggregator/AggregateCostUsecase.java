package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.aggregate.AggregatorResponse;
import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;

import java.util.List;

public interface AggregateCostUsecase {
    AggregatorResponse execute(List<Cost> costs, Period period);
}

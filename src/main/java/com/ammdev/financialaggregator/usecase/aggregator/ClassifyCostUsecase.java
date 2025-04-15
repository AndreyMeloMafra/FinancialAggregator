package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.aggregate.AggregatorResponse;
import com.ammdev.financialaggregator.domain.aggregate.Cost;

import java.util.List;

public interface ClassifyCostUsecase {
    AggregatorResponse classifyCost(List<Cost> costs);
}

package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.AggregatorResponse;
import com.ammdev.financialaggregator.domain.Cost;

import java.util.List;

public interface ClassifyCostUsecase {
    AggregatorResponse classifyCost(List<Cost> costs);
}

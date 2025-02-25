package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.Period;

import java.util.List;

public interface AggregateProductCostUsecase {

    List<Cost> retrieveCost(List<Cost> costs, Period period);
}

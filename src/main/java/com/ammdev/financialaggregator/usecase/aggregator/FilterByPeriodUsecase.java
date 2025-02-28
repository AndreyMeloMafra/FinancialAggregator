package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;

import java.util.List;

public interface FilterByPeriodUsecase {
    List<Cost> execute(List<Cost> costs, Period period);
}

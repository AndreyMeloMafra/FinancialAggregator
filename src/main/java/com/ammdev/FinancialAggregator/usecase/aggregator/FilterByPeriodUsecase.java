package com.ammdev.FinancialAggregator.usecase.aggregator;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.Period;

import java.util.List;

public interface FilterByPeriodUsecase {
    List<Cost> execute(List<Cost> costs, Period period);
}

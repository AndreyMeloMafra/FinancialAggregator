package com.ammdev.financialaggregator.usecase.aggregator;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.Period;

import java.util.List;

public interface FilterByPeriodUsecase {
    List<Cost> execute(List<Cost> costs, Period period);
}

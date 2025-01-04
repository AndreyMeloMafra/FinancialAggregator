package com.ammdev.FinancialAggregator.usecase.aggregator.impl;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.Period;
import com.ammdev.FinancialAggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.FinancialAggregator.utils.DateUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

public class FilterByPeriodUsecaseImpl implements FilterByPeriodUsecase {

    @Override
    public List<Cost> execute(List<Cost> costs, Period period) {
        if (ObjectUtils.isEmpty(costs)) {
            return new ArrayList<>();
        }

        return costs.stream()
                .filter(cost ->
                        DateUtils.isDateBetween(cost.getDate(), period.startDate(), period.endDate()))
                .toList();
    }
}

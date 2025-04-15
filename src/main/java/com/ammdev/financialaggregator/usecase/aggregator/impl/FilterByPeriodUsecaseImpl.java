package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.financialaggregator.utils.DateUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class FilterByPeriodUsecaseImpl implements FilterByPeriodUsecase {

    @Override
    public List<Cost> execute(List<Cost> costs, Period period) {
        if (ObjectUtils.isEmpty(costs)) {
            return new ArrayList<>();
        }

        return costs.stream()
                .filter(cost ->
                        DateUtils.isDateBetween(cost.date(), period.startDate(), period.endDate()))
                .toList();
    }
}

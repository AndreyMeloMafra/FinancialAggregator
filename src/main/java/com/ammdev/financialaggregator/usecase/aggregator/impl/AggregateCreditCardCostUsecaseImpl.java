package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.CostSource;
import com.ammdev.financialaggregator.domain.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class AggregateCreditCardCostUsecaseImpl implements AggregateProductCostUsecase {
    private final FilterByPeriodUsecase filterByPeriodUsecase;

    @Override
    public List<Cost> retrieveCost(List<Cost> costs, Period period) {
        List<Cost> filteredCosts = filterByPeriodUsecase.execute(costs, period);

        return filteredCosts.stream().filter(cost -> CostSource.CREDIT_CARD.equals(cost.getCostSource())).toList();
    }
}

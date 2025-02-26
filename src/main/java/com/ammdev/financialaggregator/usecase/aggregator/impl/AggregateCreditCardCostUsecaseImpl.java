package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.CostSource;
import com.ammdev.financialaggregator.domain.Period;
import com.ammdev.financialaggregator.external.client.CardClient;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateCreditCardCostUsecaseImpl implements AggregateProductCostUsecase {
    private final FilterByPeriodUsecase filterByPeriodUsecase;
    private final CardClient cardClient;

    public AggregateCreditCardCostUsecaseImpl(FilterByPeriodUsecase filterByPeriodUsecase, CardClient cardClient) {
        this.filterByPeriodUsecase = filterByPeriodUsecase;
        this.cardClient = cardClient;
    }

    @Override
    public List<Cost> retrieveCost(Period period) {
        List<Cost> cardCosts =  cardClient.listCreditCard("user", "token");
        List<Cost> filteredCosts = filterByPeriodUsecase.execute(cardCosts, period);

        return filteredCosts.stream().filter(cost -> CostSource.CREDIT_CARD.equals(cost.costSource())).toList();
    }
}

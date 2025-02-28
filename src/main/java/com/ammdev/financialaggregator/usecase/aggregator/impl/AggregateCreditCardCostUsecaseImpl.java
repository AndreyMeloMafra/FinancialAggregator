package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.CostSource;
import com.ammdev.financialaggregator.domain.Period;
import com.ammdev.financialaggregator.external.client.CardClient;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateProductCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.financialaggregator.usecase.validation.ValidatorUsecase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AggregateCreditCardCostUsecaseImpl implements AggregateProductCostUsecase {
    private final FilterByPeriodUsecase filterByPeriodUsecase;
    private final CardClient cardClient;
    private final ValidatorUsecase validatorUsecase;

    public AggregateCreditCardCostUsecaseImpl(FilterByPeriodUsecase filterByPeriodUsecase, CardClient cardClient, ValidatorUsecase validatorUsecase) {
        this.filterByPeriodUsecase = filterByPeriodUsecase;
        this.cardClient = cardClient;
        this.validatorUsecase = validatorUsecase;
    }

    @Override
    public List<Cost> retrieveCost(Period period) {
        List<Cost> cardCostList =  cardClient.listCreditCard("user", "token");
        List<Cost> filteredCosts = filterByPeriodUsecase.execute(cardCostList, period);

        List<Cost> cardCost = filteredCosts.stream().filter(cost -> CostSource.CREDIT_CARD.equals(cost.costSource())).toList();

        validatorUsecase.validate(cardCost);

        return cardCost;


    }
}

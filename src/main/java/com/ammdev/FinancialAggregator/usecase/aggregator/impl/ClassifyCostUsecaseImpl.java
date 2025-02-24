package com.ammdev.FinancialAggregator.usecase.aggregator.impl;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;
import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.CostSource;
import com.ammdev.FinancialAggregator.usecase.aggregator.ClassifyCostUsecase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassifyCostUsecaseImpl implements ClassifyCostUsecase {

    @Override
    public AggregatorResponse classifyCost(final List<Cost> costs) {
        List<Cost> accountCosts = costs.stream().filter(cost -> cost.getCostSource().equals(CostSource.BANK_ACCOUNT)).toList();
        List<Cost> creditCardCosts = costs.stream().filter(cost -> cost.getCostSource().equals(CostSource.CREDIT_CARD)).toList();
        List<Cost> financingCosts = costs.stream().filter(cost -> cost.getCostSource().equals(CostSource.FINANCING)).toList();
        List<Cost> loanCosts = costs.stream().filter(cost -> cost.getCostSource().equals(CostSource.LOAN)).toList();

        List<Cost> others = new ArrayList<>(costs);

        others.removeAll(accountCosts);
        others.removeAll(creditCardCosts);
        others.removeAll(financingCosts);
        others.removeAll(loanCosts);

        return AggregatorResponse.builder()
                .accounts(accountCosts)
                .creditCards(creditCardCosts)
                .financings(financingCosts)
                .loans(loanCosts)
                .others(others)
                .build();
    }
}

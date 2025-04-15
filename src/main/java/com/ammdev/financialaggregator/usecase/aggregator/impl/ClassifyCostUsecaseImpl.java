package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.aggregate.AggregatorResponse;
import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.CostSource;
import com.ammdev.financialaggregator.usecase.aggregator.CalculateTotalCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.ClassifyCostUsecase;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClassifyCostUsecaseImpl implements ClassifyCostUsecase {
    private  final CalculateTotalCostUsecase calculateTotalCostUsecase;

    public ClassifyCostUsecaseImpl(CalculateTotalCostUsecase calculateTotalCostUsecase) {
        this.calculateTotalCostUsecase = calculateTotalCostUsecase;
    }

    @Override
    public AggregatorResponse classifyCost(final List<Cost> costs) {
        List<Cost> accountCosts = costs.stream().filter(cost -> cost.costSource().equals(CostSource.BANK_ACCOUNT)).toList();
        List<Cost> creditCardCosts = costs.stream().filter(cost -> cost.costSource().equals(CostSource.CREDIT_CARD)).toList();
        List<Cost> financingCosts = costs.stream().filter(cost -> cost.costSource().equals(CostSource.FINANCING)).toList();
        List<Cost> loanCosts = costs.stream().filter(cost -> cost.costSource().equals(CostSource.LOAN)).toList();

        List<Cost> others = new ArrayList<>(costs);

        Double totalValue = calculateTotalCostUsecase.execute(costs);

        others.removeAll(accountCosts);
        others.removeAll(creditCardCosts);
        others.removeAll(financingCosts);
        others.removeAll(loanCosts);

        return AggregatorResponse.builder()
                .totalValue(totalValue)
                .accounts(accountCosts)
                .creditCards(creditCardCosts)
                .financings(financingCosts)
                .loans(loanCosts)
                .others(others)
                .build();
    }
}

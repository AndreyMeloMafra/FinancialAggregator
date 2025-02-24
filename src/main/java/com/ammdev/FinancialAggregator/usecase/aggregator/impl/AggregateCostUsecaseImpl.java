package com.ammdev.FinancialAggregator.usecase.aggregator.impl;

import com.ammdev.FinancialAggregator.domain.AggregatorResponse;
import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.Period;
import com.ammdev.FinancialAggregator.usecase.aggregator.AggregateCostUsecase;
import com.ammdev.FinancialAggregator.usecase.aggregator.CalculateTotalCostUsecase;
import com.ammdev.FinancialAggregator.usecase.aggregator.ClassifyCostUsecase;
import com.ammdev.FinancialAggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.FinancialAggregator.usecase.validation.ValidatorUsecase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AggregateCostUsecaseImpl implements AggregateCostUsecase {
    private final FilterByPeriodUsecase filterByPeriodUsecase;
    private final CalculateTotalCostUsecase calculateTotalCostUsecase;
    private final ClassifyCostUsecase classifyCostUsecase;
    private final ValidatorUsecase validatorUsecase;

    public AggregateCostUsecaseImpl(
            FilterByPeriodUsecase filterByPeriodUsecase,
            CalculateTotalCostUsecase calculateTotalCostUsecase,
            ClassifyCostUsecase classifyCostUsecase,
            ValidatorUsecase validatorUsecase) {
        this.filterByPeriodUsecase = filterByPeriodUsecase;
        this.calculateTotalCostUsecase = calculateTotalCostUsecase;
        this.classifyCostUsecase = classifyCostUsecase;
        this.validatorUsecase = validatorUsecase;
    }

    @Override
    public AggregatorResponse execute(List<Cost> costs, Period period) {
        List<Cost> filteredCosts = filterByPeriodUsecase.execute(costs, period);

        doValidationCost(filteredCosts);

        Double totalCost = calculateTotalCostUsecase.execute(filteredCosts);
        AggregatorResponse classifiedCosts = classifyCostUsecase.classifyCost(filteredCosts);

        classifiedCosts.setTotalValue(totalCost);

        return classifiedCosts;
    }

    private void doValidationCost(List<Cost> costs) {
        costs.forEach(validatorUsecase::validate);
    }
}

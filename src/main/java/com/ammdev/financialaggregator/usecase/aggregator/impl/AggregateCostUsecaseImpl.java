package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.AggregatorResponse;
import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.CalculateTotalCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.ClassifyCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.financialaggregator.usecase.validation.ValidatorUsecase;
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
        validatorUsecase.validate(costs);
    }
}

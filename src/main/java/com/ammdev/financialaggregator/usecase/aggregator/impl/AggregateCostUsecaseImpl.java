package com.ammdev.financialaggregator.usecase.aggregator.impl;

import com.ammdev.financialaggregator.domain.aggregate.AggregatorResponse;
import com.ammdev.financialaggregator.domain.aggregate.Cost;
import com.ammdev.financialaggregator.domain.aggregate.Period;
import com.ammdev.financialaggregator.usecase.aggregator.AggregateCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.ClassifyCostUsecase;
import com.ammdev.financialaggregator.usecase.aggregator.FilterByPeriodUsecase;
import com.ammdev.financialaggregator.usecase.validation.ValidatorUsecase;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AggregateCostUsecaseImpl implements AggregateCostUsecase {
    private final FilterByPeriodUsecase filterByPeriodUsecase;
    private final ClassifyCostUsecase classifyCostUsecase;
    private final ValidatorUsecase validatorUsecase;

    public AggregateCostUsecaseImpl(
            FilterByPeriodUsecase filterByPeriodUsecase,
            ClassifyCostUsecase classifyCostUsecase,
            ValidatorUsecase validatorUsecase) {
        this.filterByPeriodUsecase = filterByPeriodUsecase;
        this.classifyCostUsecase = classifyCostUsecase;
        this.validatorUsecase = validatorUsecase;
    }

    @Override
    public AggregatorResponse execute(List<Cost> costs, Period period) {
        List<Cost> filteredCosts = filterByPeriodUsecase.execute(costs, period);
        doValidationCost(filteredCosts);

        return classifyCostUsecase.classifyCost(filteredCosts);
    }

    private void doValidationCost(List<Cost> costs) {
        validatorUsecase.validate(costs);
    }
}

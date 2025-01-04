package com.ammdev.FinancialAggregator.usecase.aggregator.impl;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.exception.InvalidMonetaryValueException;
import com.ammdev.FinancialAggregator.usecase.aggregator.CalculateTotalCostUsecase;
import com.ammdev.FinancialAggregator.usecase.aggregator.Constants;
import org.springframework.util.ObjectUtils;

import java.util.List;

public class CalculateTotalCostUsecaseImpl implements CalculateTotalCostUsecase {

    @Override
    public Double execute(List<Cost> costs) {
        Double totalCost = 0.0;

        if (ObjectUtils.isEmpty(costs)) {
            return totalCost;
        }

        for (Cost cost : costs) {
            totalCost += getCostToSum(cost);
        }

        return totalCost;
    }

    private Double getCostToSum(Cost cost) {
        if (validateCostValue(cost)) {
            throw new InvalidMonetaryValueException(Constants.INVALID_MONETARY_VALUE_EXCEPTION_DETAIL);
        }

        return cost.getValue();
    }

    private boolean validateCostValue(Cost cost) {
        return ObjectUtils.isEmpty(cost.getValue());
    }
}

package com.ammdev.financialaggregator.usecase.cost;

import com.ammdev.financialaggregator.domain.aggregate.Cost;

public interface CreateCostUsecase {
    void createCost(Cost cost);
}

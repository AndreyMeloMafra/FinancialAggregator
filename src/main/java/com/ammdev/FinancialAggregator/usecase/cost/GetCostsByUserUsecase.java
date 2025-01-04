package com.ammdev.FinancialAggregator.usecase.cost;

import com.ammdev.FinancialAggregator.domain.Cost;

import java.util.List;

public interface GetCostsByUserUsecase {
    List<Cost> getCostsByUser(String userId);
}

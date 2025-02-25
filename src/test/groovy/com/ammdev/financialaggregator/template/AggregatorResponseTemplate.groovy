package com.ammdev.financialaggregator.template;

import com.ammdev.financialaggregator.domain.AggregatorResponse;

import java.util.List;

class AggregatorResponseTemplate {

    static AggregatorResponse getOne() {
        return AggregatorResponse.builder()
                .totalValue(450.0)
                .creditCards(List.of(CostTemplate.createCreditCardCost()))
                .build();
    }
}

package com.ammdev.FinancialAggregator.template;

import com.ammdev.FinancialAggregator.domain.CostType;
import com.ammdev.FinancialAggregator.domain.Instalment;

public class InstalmentTemplate {

    public static Instalment createInstalment() {
        return Instalment.builder()
                .value(150.00)
                .number(1)
                .costType(CostType.SINGLE)
                .startDate("2025-01-03")
                .lateFee(TaxTemplate.createTax())
                .build();
    }
}

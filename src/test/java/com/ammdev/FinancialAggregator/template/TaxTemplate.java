package com.ammdev.FinancialAggregator.template;

import com.ammdev.FinancialAggregator.domain.Tax;

public class TaxTemplate {

    public static Tax createTax() {
        return Tax.builder()
                .value(150.00)
                .currency("BRL")
                .build();
    }
}

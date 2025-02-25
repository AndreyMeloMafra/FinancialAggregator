package com.ammdev.financialaggregator.template;

import com.ammdev.financialaggregator.domain.Tax;

public class TaxTemplate {

    public static Tax createTax() {
        return Tax.builder()
                .value(150.00)
                .currency("BRL")
                .build();
    }
}

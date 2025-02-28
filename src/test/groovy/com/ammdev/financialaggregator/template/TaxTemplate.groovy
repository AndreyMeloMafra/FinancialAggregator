package com.ammdev.financialaggregator.template;

import com.ammdev.financialaggregator.domain.aggregate.Tax;

class TaxTemplate {

    static Tax createTax() {
        return Tax.builder()
                .value(150.00)
                .currency("BRL")
                .build();
    }
}

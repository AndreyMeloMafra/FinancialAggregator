package com.ammdev.financialaggregator.template

import com.ammdev.financialaggregator.domain.aggregate.CostType
import com.ammdev.financialaggregator.domain.aggregate.Instalment

class InstalmentTemplate {

    static Instalment createInstalment() {
        return Instalment.builder()
                .value(150.00)
                .number(1)
                .costType(CostType.SINGLE)
                .startDate("2025-01-03")
                .lateFee(TaxTemplate.createTax())
                .build()
    }
}

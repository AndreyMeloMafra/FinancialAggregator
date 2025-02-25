package com.ammdev.financialaggregator.template;

import com.ammdev.financialaggregator.domain.Cost;
import com.ammdev.financialaggregator.domain.CostSource;

import java.util.List;

class CostTemplate {

    static Cost createCreditCardCost() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    static Cost createFinancingCost() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.FINANCING)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    static Cost createLoanCost() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.LOAN)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    static Cost createDebitCardCost() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.DEBIT_CARD)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .build();
    }

    static Cost createCreditCardWithoutInstalment() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .build();
    }

    static Cost createFinancingWithoutInstalment() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.FINANCING)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .build();
    }

    static Cost createLoanWithoutInstalment() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.LOAN)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .build();
    }

    static Cost createCostWithNullValue() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(null)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    static Cost createCostWithInvalidPattern() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(150.0)
                .date("202112-0001-0001")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    static List<Cost> createManyCosts() {
        return List.of(
                Cost.builder()
                        .name("Cost 1")
                        .costSource(CostSource.CREDIT_CARD)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 2")
                        .costSource(CostSource.FINANCING)
                        .description("Description")
                        .value(150.00)
                        .date("2021-01-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 3")
                        .costSource(CostSource.LOAN)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build()
        );
    }

    static List<Cost> createCostsWithMultipleCostSources() {
        return List.of(
                Cost.builder()
                        .name("Cost 1")
                        .costSource(CostSource.CREDIT_CARD)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 2")
                        .costSource(CostSource.FINANCING)
                        .description("Description")
                        .value(150.00)
                        .date("2021-01-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 3")
                        .costSource(CostSource.LOAN)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 3")
                        .costSource(CostSource.INVESTMENT)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build(),
                Cost.builder()
                        .name("Cost 3")
                        .costSource(CostSource.BANK_ACCOUNT)
                        .description("Description")
                        .value(150.00)
                        .date("2021-02-01")
                        .instalment(InstalmentTemplate.createInstalment())
                        .build()
        );
    }
}

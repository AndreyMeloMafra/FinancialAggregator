package com.ammdev.FinancialAggregator.template;

import com.ammdev.FinancialAggregator.domain.Cost;
import com.ammdev.FinancialAggregator.domain.CostSource;

import java.util.List;

public class CostTemplate {

    public static Cost createCost() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(150.00)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    public static Cost createCostWithNullValue() {
        return Cost.builder()
                .name("Cost 1")
                .costSource(CostSource.CREDIT_CARD)
                .description("Description")
                .value(null)
                .date("2021-01-01")
                .instalment(InstalmentTemplate.createInstalment())
                .build();
    }

    public static List<Cost> createManyCosts() {
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

    public static List<Cost> createCostsWithMultipleCostSources() {
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

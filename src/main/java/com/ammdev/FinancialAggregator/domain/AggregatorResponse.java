package com.ammdev.FinancialAggregator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.List;

@AllArgsConstructor
@Builder
public class AggregatorResponse {

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Double totalValue;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cost> financings;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cost> loans;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cost> creditCards;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cost> accounts;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<Cost> others;
}

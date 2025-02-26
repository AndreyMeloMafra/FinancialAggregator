package com.ammdev.financialaggregator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

@Builder
public record AggregatorResponse(
        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Double totalValue,

        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Cost> financings,

        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Cost> loans,
        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Cost> creditCards,
        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Cost> accounts,

        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        List<Cost> others
) implements Serializable {


}

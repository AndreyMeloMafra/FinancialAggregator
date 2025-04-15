package com.ammdev.financialaggregator.domain.aggregate;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record Instalment(
        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Integer number,

        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Double value,

        @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
        @Pattern(regexp = Constants.DATE_PATTERN, message = Constants.DATE_PATTERN_MESSAGE)
        String startDate,

        @Valid
        @NotNull(message = Constants.NOT_BLANK_MESSAGE)
        CostType costType,

        @Valid
        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Tax lateFee
) implements Serializable {
}

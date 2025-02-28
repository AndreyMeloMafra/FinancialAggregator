package com.ammdev.financialaggregator.domain.aggregate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record Tax(
        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Double value,

        @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
        @Pattern(regexp = Constants.CURRENCY_PATTERN, message = Constants.CURRENCY_MESSAGE)
        String currency
) implements Serializable {
}

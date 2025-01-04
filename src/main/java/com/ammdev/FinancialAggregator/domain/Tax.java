package com.ammdev.FinancialAggregator.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public class Tax {

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    @Pattern(regexp = Constants.VALUE_PATTERN, message = Constants.VALUE_PATTERN_MESSAGE)
    private Double value;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.CURRENCY_PATTERN, message = Constants.CURRENCY_MESSAGE)
    private String currency;
}

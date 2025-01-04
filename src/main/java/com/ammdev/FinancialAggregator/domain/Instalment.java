package com.ammdev.FinancialAggregator.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Instalment {
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Integer number;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Double value;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.DATE_PATTERN, message = Constants.DATE_PATTERN_MESSAGE)
    private String startDate;

    @Valid
    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.COST_TYPE_PATTERN, message = Constants.OUT_OF_PATTERN_MESSAGE)
    private CostType costType;

    @Valid
    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private Tax lateFee;
}

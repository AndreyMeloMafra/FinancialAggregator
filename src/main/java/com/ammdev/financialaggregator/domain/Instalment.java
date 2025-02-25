package com.ammdev.financialaggregator.domain;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Builder
@Getter
public class Instalment implements Serializable {
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Integer number;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Double value;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.DATE_PATTERN, message = Constants.DATE_PATTERN_MESSAGE)
    private String startDate;

    @Valid
    @NotNull(message = Constants.NOT_BLANK_MESSAGE)
    private CostType costType;

    @Valid
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Tax lateFee;
}

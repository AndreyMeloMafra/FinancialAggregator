package com.ammdev.financialaggregator.domain;

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
public class Tax implements Serializable {

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Double value;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.CURRENCY_PATTERN, message = Constants.CURRENCY_MESSAGE)
    private String currency;
}

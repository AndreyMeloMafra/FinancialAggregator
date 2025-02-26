package com.ammdev.financialaggregator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

import java.io.Serializable;

@Builder
public record Cost(
        @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
        String name,

        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        String description,

        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        Double value,

        @Valid
        @JsonInclude(JsonInclude.Include.NON_EMPTY)
        Instalment instalment,

        @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
        @Pattern(regexp = Constants.DATE_PATTERN, message = Constants.DATE_PATTERN_MESSAGE)
        String date,

        @Valid
        @NotNull(message = Constants.NOT_NULL_MESSAGE)
        CostSource costSource
) implements Serializable {

}

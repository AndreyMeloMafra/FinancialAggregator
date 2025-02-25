package com.ammdev.financialaggregator.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class Cost implements Serializable {
    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    private String name;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private String description;

    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private Double value;

    @Valid
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private Instalment instalment;

    @NotBlank(message = Constants.NOT_BLANK_MESSAGE)
    @Pattern(regexp = Constants.DATE_PATTERN, message = Constants.DATE_PATTERN_MESSAGE)
    private String date;

    // Se costSource for igual a CREDIT_CARD, FINANCING ou LOAN, o campo instalment é obrigatório
    @Valid
    @NotNull(message = Constants.NOT_NULL_MESSAGE)
    private CostSource costSource;
}

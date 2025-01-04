package com.ammdev.FinancialAggregator.usecase.aggregator;

import lombok.NoArgsConstructor;

@NoArgsConstructor(access = lombok.AccessLevel.PRIVATE)
public class Constants {
    public static final String INVALID_MONETARY_VALUE_EXCEPTION_DETAIL = "Existe algum custo com valor inválido (Nulo, Vazio ou não é um número real)";
}

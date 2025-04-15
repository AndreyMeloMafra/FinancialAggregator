package com.ammdev.financialaggregator.domain.aggregate;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Constants {
    public static final String NOT_BLANK_MESSAGE = "não pode ser vazio ou nulo";
    public static final String NOT_NULL_MESSAGE = "não pode ser nulo";

    public static final String DATE_PATTERN_MESSAGE = "deve estar no formato yyyy-MM-dd";
    public static final String DATE_PATTERN = "^(?:19|20)\\d\\d-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12]\\d|3[01])$";

    public static final String CURRENCY_MESSAGE = "deve estar no padrão ISO 4217";
    public static final String CURRENCY_PATTERN = "^[A-Z]{3}$";

    public static final String INVALID_DATE_PERIOD_EXCEPTION_DETAIL = "As datas de início e fim do período são obrigatórias";
    public static final String DATE_RANGE_PERIOD_EXCEPTION_DETAIL = "A data de início do período deve ser anterior a data de fim";
    public static final String INVALID_STRING_DATE_EXCEPTION_DETAIL = "As datas de início e fim do período devem estar no formato yyyy-MM-dd";
}

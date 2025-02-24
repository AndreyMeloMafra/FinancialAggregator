package com.ammdev.FinancialAggregator.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
public class Error implements Serializable {

    private final Integer code;
    private final String message;
    private final String detail;
}

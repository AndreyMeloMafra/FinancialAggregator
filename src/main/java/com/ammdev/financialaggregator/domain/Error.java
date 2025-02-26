package com.ammdev.financialaggregator.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

//@RequiredArgsConstructor
public record Error(
        Integer code,
        String message,
        String detail
) implements Serializable {
}

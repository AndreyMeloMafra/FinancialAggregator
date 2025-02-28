package com.ammdev.financialaggregator.domain;

import java.io.Serializable;

public record Error(
        Integer code,
        String message,
        String detail
) implements Serializable {
}

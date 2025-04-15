package com.ammdev.financialaggregator.domain.aggregate;

import lombok.Getter;

@Getter
public enum CostType {
    INSTALMENT("Parcelado"),
    SINGLE("Único"),
    PAYROLL_LOAN("Consignado");

    private final String descricao;

    CostType(String descricao) {
        this.descricao = descricao;
    }
}
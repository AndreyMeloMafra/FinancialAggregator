package com.ammdev.financialaggregator.domain;

import lombok.Getter;

@Getter
public enum CostSource {
    CREDIT_CARD("Cartão de Crédito"),
    DEBIT_CARD("Cartão de Débito"),
    BANK_TRANSFER("Transferência Bancária"),
    LOAN("Empréstimo"),
    FINANCING("Financiamento"),
    BANK_ACCOUNT("Conta Bancária"),
    INVESTMENT("Investimento"),
    CASH("Dinheiro"),
    OTHER("Outro");

    private final String descricao;

    CostSource(String descricao) {
        this.descricao = descricao;
    }
}

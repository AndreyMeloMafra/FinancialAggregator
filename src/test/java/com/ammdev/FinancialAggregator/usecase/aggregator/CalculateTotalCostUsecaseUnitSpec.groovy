package com.ammdev.FinancialAggregator.usecase.aggregator

import com.ammdev.FinancialAggregator.domain.Cost
import com.ammdev.FinancialAggregator.exception.InvalidMonetaryValueException
import com.ammdev.FinancialAggregator.template.CostTemplate
import com.ammdev.FinancialAggregator.usecase.aggregator.impl.CalculateTotalCostUsecaseImpl
import spock.lang.Specification

class CalculateTotalCostUsecaseUnitSpec extends Specification {

    CalculateTotalCostUsecase calculateTotalCostUsecase

    def setup() {
        calculateTotalCostUsecase = new CalculateTotalCostUsecaseImpl()
    }

    def "Deve retornar o valor total da somatória de uma lista de custos com apenas um item"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(CostTemplate.createCost())

        when: "Executar o caso de uso para realizar o calculo de valor total"
        Double result = calculateTotalCostUsecase.execute(costs)

        then: "Deve retornar o valor da soma de todos os custos"
        result == 150.00
    }

    def "Deve retornar 0.0 quando a lista de custos for vazia"() {
        given: "Uma lista de custos vazia"
        List<Cost> costs = List.of()

        when: "Executar o caso de uso para realizar o calculo de valor total"
        Double result = calculateTotalCostUsecase.execute(costs)

        then: "Deve retornar 0.0"
        result == 0.0
    }

    def "Deve retornar o valor total da somatória de uma lista de custos com 1000 items"() {
        given: "Uma lista com 1000 custos"
        var qtdCosts = 1000
        List<Cost> costs = Collections.nCopies(qtdCosts, CostTemplate.createCost())

        when: "Executar o caso de uso para realizar o calculo de valor total"
        Double result = calculateTotalCostUsecase.execute(costs)

        then: "Deve retornar o valor da soma de todos os custos"
        result == 150.00 * qtdCosts
    }

    def "Deve lançar uma exceção quando o valor vier inválido da fonte"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(CostTemplate.createCost(), CostTemplate.createCost(), CostTemplate.createCostWithNullValue())

        when: "Executar o caso de uso para realizar o calculo de valor total"
        calculateTotalCostUsecase.execute(costs)

        then: "Deve lançar uma exception de valor inválido"
        thrown(InvalidMonetaryValueException)
    }
}

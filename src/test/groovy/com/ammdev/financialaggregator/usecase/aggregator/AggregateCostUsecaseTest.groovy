package com.ammdev.financialaggregator.usecase.aggregator

import com.ammdev.financialaggregator.domain.AggregatorResponse
import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.domain.Period
import com.ammdev.financialaggregator.template.AggregatorResponseTemplate
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCostUsecaseImpl
import com.ammdev.financialaggregator.usecase.validation.ValidatorUsecase
import spock.lang.Specification

class AggregateCostUsecaseTest extends Specification {

    AggregateCostUsecase aggregateCostUsecase

    CalculateTotalCostUsecase calculateTotalCostUsecase = Mock()

    FilterByPeriodUsecase filterByPeriodUsecase = Mock()

    ClassifyCostUsecase classifyCostUsecase = Mock()

    ValidatorUsecase validatorUsecase = Mock()

    def setup() {
        aggregateCostUsecase = new AggregateCostUsecaseImpl(filterByPeriodUsecase, calculateTotalCostUsecase, classifyCostUsecase, validatorUsecase)
    }

    def "Deve retornar um AggregatorResponse com o valor total e a lista de custos"() {
        given: "Um AggregatorResponse válido"
        AggregatorResponse aggregatorResponse = AggregatorResponseTemplate.getOne()

        and: "Uma lista de custos válida"
        List<Cost> costs = aggregatorResponse.creditCards

        and: "Um periodo para filtrar"
        String startDate = "2020-01-01"
        String endDate = "2021-01-31"
        Period period = new Period(startDate, endDate)

        1 * filterByPeriodUsecase.execute(costs, period) >> costs
        1 * calculateTotalCostUsecase.execute(costs) >> 450.00
        1 * classifyCostUsecase.classifyCost(costs) >> aggregatorResponse

        when: "Executar o caso de uso para realizar o calculo de valor total"
        AggregatorResponse result = aggregateCostUsecase.execute(costs, period)

        then: "Deve retornar um AggregateResponse com o valor total e a lista de custos"
        result.totalValue == 450.00

        1 * validatorUsecase.validate(costs)
    }
}

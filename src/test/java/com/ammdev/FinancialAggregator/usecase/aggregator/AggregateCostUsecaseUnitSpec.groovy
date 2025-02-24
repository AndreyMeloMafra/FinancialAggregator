package com.ammdev.FinancialAggregator.usecase.aggregator

import com.ammdev.FinancialAggregator.domain.AggregatorResponse
import com.ammdev.FinancialAggregator.domain.Cost
import com.ammdev.FinancialAggregator.domain.Period
import com.ammdev.FinancialAggregator.template.CostTemplate
import com.ammdev.FinancialAggregator.usecase.aggregator.impl.AggregateCostUsecaseImpl
import com.ammdev.FinancialAggregator.usecase.validation.ValidatorUsecase
import spock.lang.Specification

class AggregateCostUsecaseUnitSpec extends Specification {

    AggregateCostUsecase aggregateCostUsecase

    CalculateTotalCostUsecase calculateTotalCostUsecase = Mock()

    FilterByPeriodUsecase filterByPeriodUsecase = Mock()

    ClassifyCostUsecase classifyCostUsecase = Mock()

    ValidatorUsecase validatorUsecase = Mock()

    def setup() {
        aggregateCostUsecase = new AggregateCostUsecaseImpl(filterByPeriodUsecase, calculateTotalCostUsecase, classifyCostUsecase, validatorUsecase)
    }

    def "Deve retornar um AggregatorResponse com o valor total e a lista de custos"() {
        given: "Uma lista de custos"
        List<Cost> costs = CostTemplate.createManyCosts()

        and: "Um periodo para filtrar"
        String startDate = "2020-01-01"
        String endDate = "2021-01-31"
        Period period = new Period(startDate, endDate)

        1 * filterByPeriodUsecase.execute(costs, period) >> costs
        1 * calculateTotalCostUsecase.execute(costs) >> 450.00

        when: "Executar o caso de uso para realizar o calculo de valor total"
        AggregatorResponse result = aggregateCostUsecase.execute(costs, period)

        then: "Deve retornar um AggregateResponse com o valor total e a lista de custos"
        result.totalValue == 450.00
    }
}

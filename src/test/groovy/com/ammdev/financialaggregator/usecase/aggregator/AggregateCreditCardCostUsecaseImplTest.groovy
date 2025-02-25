package com.ammdev.financialaggregator.usecase.aggregator

import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.domain.CostSource
import com.ammdev.financialaggregator.domain.Period
import com.ammdev.financialaggregator.template.CostTemplate
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCreditCardCostUsecaseImpl
import spock.lang.Specification

class AggregateCreditCardCostUsecaseImplTest extends Specification {

    AggregateProductCostUsecase aggregateProductCostUsecase

    FilterByPeriodUsecase filterByPeriodUsecase = Mock()

    void setup() {
        aggregateProductCostUsecase = new AggregateCreditCardCostUsecaseImpl(filterByPeriodUsecase)
    }

    def "Deve trazer a lista de custos de cartão de crédito"() {
        given: "Uma lista de custos de vários tipos"
        List<Cost> costs = CostTemplate.createManyCosts()

        and:
        List<Cost> cresitCardCosts = costs.stream()
                .filter(cost -> CostSource.CREDIT_CARD.equals(cost.costSource)).toList()

        and: "Um periodo válido"
        Period period = new Period("2024-01-01", "2024-12-31")

        1 * filterByPeriodUsecase.execute(costs, period) >> cresitCardCosts

        when: "Recupera os custos de um cartão de crédito"
        List<Cost> costAggregated = aggregateProductCostUsecase.retrieveCost(costs, period)

        then: "Deve retornar apenas os custos relacionados a cartão de crédito"
        costAggregated == cresitCardCosts
    }
}

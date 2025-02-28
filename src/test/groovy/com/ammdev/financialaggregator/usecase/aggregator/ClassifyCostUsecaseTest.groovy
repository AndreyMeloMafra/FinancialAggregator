package com.ammdev.financialaggregator.usecase.aggregator

import com.ammdev.financialaggregator.domain.AggregatorResponse
import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.template.CostTemplate
import com.ammdev.financialaggregator.usecase.aggregator.impl.ClassifyCostUsecaseImpl
import spock.lang.Specification

class ClassifyCostUsecaseTest extends Specification {

    ClassifyCostUsecase classifyCostUsecase
    CalculateTotalCostUsecase calculateTotalCostUsecase = Mock()

    def setup() {
        classifyCostUsecase = new ClassifyCostUsecaseImpl(calculateTotalCostUsecase)
    }

    def "Deve retornar um aggregatorResponse com pelo menos um item em cada categoria"() {
        given: "Uma lista de custos"
        List<Cost> costs = CostTemplate.createCostsWithMultipleCostSources()

        and: "deve calcular o valor total dos custos"
        1 * calculateTotalCostUsecase.execute(costs) >> 750.0

        when: "Classificar os custos"
        AggregatorResponse aggregatorResponse = classifyCostUsecase.classifyCost(costs)

        then: "Deve classificar os custos"
        aggregatorResponse.creditCards().size() == 1
        aggregatorResponse.accounts().size() == 1
        aggregatorResponse.loans().size() == 1
        aggregatorResponse.financings().size() == 1
        aggregatorResponse.others().size() == 1
    }
}

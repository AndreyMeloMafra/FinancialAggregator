package com.ammdev.financialaggregator.usecase.aggregator

import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.domain.CostSource
import com.ammdev.financialaggregator.domain.Period
import com.ammdev.financialaggregator.external.client.CardClient
import com.ammdev.financialaggregator.template.CostTemplate
import com.ammdev.financialaggregator.usecase.aggregator.impl.AggregateCreditCardCostUsecaseImpl
import com.ammdev.financialaggregator.usecase.validation.ValidatorUsecase
import spock.lang.Ignore
import spock.lang.Specification

class AggregateCreditCardCostUsecaseImplTest extends Specification {

    AggregateProductCostUsecase aggregateProductCostUsecase

    FilterByPeriodUsecase filterByPeriodUsecase = Mock()
    CardClient cardClient = Mock()
    ValidatorUsecase validatorUsecase = Mock()

    void setup() {
        aggregateProductCostUsecase = new AggregateCreditCardCostUsecaseImpl(filterByPeriodUsecase, cardClient, validatorUsecase)
    }

    def "Deve trazer a lista de custos de cartão de crédito"() {
        given: "Uma lista de custos de vários tipos"
        List<Cost> costs = CostTemplate.createManyCosts()

        and: "A lista de custos com apenas cartões de crédito"
        List<Cost> cresitCardCosts = costs.stream()
                .filter(cost -> CostSource.CREDIT_CARD.equals(cost.costSource())).toList()

        and: "Um periodo válido"
        Period period = new Period("2024-01-01", "2024-12-31")

        // todo: Ao implementar o modelo de Autenticação do sistema revisitar este trecho
        1 * cardClient.listCreditCard(_, _) >> costs
        1 * filterByPeriodUsecase.execute(costs, period) >> cresitCardCosts

        when: "Recupera os custos de um cartão de crédito"
        List<Cost> costAggregated = aggregateProductCostUsecase.retrieveCost(period)

        then: "Deve retornar apenas os custos relacionados a cartão de crédito"
        costAggregated == cresitCardCosts

        and: "O validador deve ser chamado"
        1 * validatorUsecase.validate(_)
    }
}

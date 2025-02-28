package com.ammdev.financialaggregator.usecase.validation

import com.ammdev.financialaggregator.domain.aggregate.Cost
import com.ammdev.financialaggregator.exception.UnprocessableEntityException
import com.ammdev.financialaggregator.template.CostTemplate
import spock.lang.Specification

class ValidationJakartaHandlerTest extends Specification {

    ValidationJakartaHandler validationJakartaHandler

    void setup() {
        validationJakartaHandler = new ValidationJakartaHandler()
    }

    def "Não deve lançar uma exceção quando as regras negociais dos campos forem atendidas"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(CostTemplate.createDebitCardCost())

        when: "O validador é chamado"
        validationJakartaHandler.validate(costs)

        then: "Não deve lançar uma exceção de UnprocessableEntity"
        notThrown(UnprocessableEntityException)
    }

    def "Deve lançar uma exceção quando as regras negociais dos campos não forem atendidas"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(CostTemplate.createCostWithInvalidPattern())

        when: "O validador é chamado"
        validationJakartaHandler.validate(costs)

        then: "Deve lançar uma exceção de UnprocessableEntity"
        def excpetion = thrown(UnprocessableEntityException)
        excpetion.getError().detail() == "O campo date: deve estar no formato yyyy-MM-dd | "
    }
}

package com.ammdev.financialaggregator.usecase.validation

import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.exception.UnprocessableEntityException
import com.ammdev.financialaggregator.template.CostTemplate
import spock.lang.Specification

class ValidateInstalmentHandlerTest extends Specification {

    ValidateInstalmentHandler validateInstalmentHandler

    void setup() {
        this.validateInstalmentHandler = new ValidateInstalmentHandler()
    }

    def "Deve validar o preenchimento de uma fatura"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(costTemplate)

        when: "O validador é chamado"
        validateInstalmentHandler.validate(costs)

        then: "Não deve lançar uma exceção de UnprocessableEntity"
        notThrown(UnprocessableEntityException)

        where: "Os tipos de custos são"
        costTemplate << [
                CostTemplate.createCreditCardCost(),
                CostTemplate.createFinancingCost(),
                CostTemplate.createLoanCost(),
                CostTemplate.createDebitCardCost()
        ]
    }

    def "Deve validar a não obrigatoriedade do preenchimento de uma fatura"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(costTemplate)

        when: "O validador é chamado"
        validateInstalmentHandler.validate(costs)

        then: "Deve lançar uma exceção de UnprocessableEntity"
        def excpetion = thrown(UnprocessableEntityException)
        excpetion.getError().detail() == "O campo instalment é obrigatório quando a fonte do custo é igual a CREDIT_CARD, FINANCING ou LOAN"

        where: "Os tipos de custos são"
        costTemplate << [
                CostTemplate.createCreditCardWithoutInstalment(),
                CostTemplate.createFinancingWithoutInstalment(),
                CostTemplate.createLoanWithoutInstalment()
        ]
    }
}

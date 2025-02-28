package com.ammdev.financialaggregator.usecase.validation

import com.ammdev.financialaggregator.domain.aggregate.Cost
import com.ammdev.financialaggregator.exception.UnprocessableEntityException
import com.ammdev.financialaggregator.template.CostTemplate
import spock.lang.Specification

class ValidatorUsecaseTest extends Specification {

    ValidatorUsecase validatorUsecase

    ValidateInstalmentHandler validateInstalmentHandler = new ValidateInstalmentHandler()

    ValidationJakartaHandler validationJakartaHandler = new ValidationJakartaHandler()

    void setup() {
        validatorUsecase = new ValidatorUsecase(validationJakartaHandler, validateInstalmentHandler)
    }

    def "Deve validar a chamada da cadeia de validação"() {
        given: "Uma lista de custos"
        List<Cost> costs = List.of(CostTemplate.createDebitCardCost())

        when: "O validador é chamado"
        validatorUsecase.validate(costs)

        then: "Não deve lançar uma exceção de UnprocessableEntity"
        notThrown(UnprocessableEntityException)
    }
}

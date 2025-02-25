package com.ammdev.financialaggregator.usecase.aggregator

import com.ammdev.financialaggregator.domain.Cost
import com.ammdev.financialaggregator.domain.Period
import com.ammdev.financialaggregator.template.CostTemplate
import com.ammdev.financialaggregator.usecase.aggregator.impl.FilterByPeriodUsecaseImpl
import spock.lang.Specification

import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FilterByPeriodUseCaseTest extends Specification{

    FilterByPeriodUsecase filterByPeriodUsecase

    def setup() {
        filterByPeriodUsecase = new FilterByPeriodUsecaseImpl()
    }

    def "Deve receber uma lista de custos e filtrar baseado no periodo"() {
        given: "Uma lista de custos"
        List<Cost> costs = CostTemplate.createManyCosts()

        and: "Um periodo para filtrar"
        String startDate = "2021-01-01"
        String endDate = "2021-03-31"
        Period period = new Period(startDate, endDate)

        when: "Filtrar por periodo"
        List<Cost> result = filterByPeriodUsecase.execute(costs, period)

        then: "Deve retornar uma lista de custos filtrada"
        result.size() == 2

        and: "Os custos filtrados devem estar dentro do periodo"
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        LocalDate localDateStartDate = LocalDate.parse(startDate, formatter)
        LocalDate localDateEndDate = LocalDate.parse(endDate, formatter)

        result.each { cost ->
            LocalDate costDate = LocalDate.parse(cost.getDate(), formatter)
            assert costDate.isAfter(localDateStartDate.minusDays(1)) && costDate.isBefore(localDateEndDate.plusDays(1))
        }
    }

    def "Deve receber uma lista vazia de custos e retornar uma lista vazia"() {
        given: "Uma lista vazia de custos"
        List<Cost> costs = []

        and: "Um periodo para filtrar"
        String startDate = "2021-01-01"
        String endDate = "2021-03-31"
        Period period = new Period(startDate, endDate)

        when: "Filtrar por periodo"
        List<Cost> result = filterByPeriodUsecase.execute(costs, period)

        then: "Deve retornar uma lista vazia"
        result.size() == 0
    }
}

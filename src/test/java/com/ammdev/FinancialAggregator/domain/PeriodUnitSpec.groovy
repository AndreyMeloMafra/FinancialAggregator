package com.ammdev.FinancialAggregator.domain

import com.ammdev.FinancialAggregator.exception.DateRangePeriodException
import com.ammdev.FinancialAggregator.exception.InvalidDatePeriodException
import com.ammdev.FinancialAggregator.exception.InvalidStringDateException
import spock.lang.Specification

class PeriodUnitSpec extends Specification {
    def "Deve lançar uma exception quando o periodo for vazio"() {
        given: "Um periodo para filtrar"
        String startDate = ""
        String endDate = ""

        when: "Filtrar por periodo"
        new Period(startDate, endDate)

        then: "Deve lançar uma exception de periodo inválido"
        thrown(InvalidDatePeriodException)
    }

    def "Deve lançar uma exception quando o periodo for inválido"() {
        given: "Um periodo para filtrar"
        String startDate = "2021-01-01"
        String endDate = "2021-03-311"

        when: "Filtrar por periodo"
        new Period(startDate, endDate)

        then: "Deve lançar uma exception de periodo inválido"
        thrown(InvalidStringDateException)
    }

    def "Deve lançar uma exception quando a data de inicio for maior que a data de fim"() {
        given: "Um periodo para filtrar"
        String startDate = "2021-01-01"
        String endDate = "2020-01-01"

        when: "Filtrar por periodo"
        new Period(startDate, endDate)

        then: "Deve lançar uma exception de periodo inválido"
        thrown(DateRangePeriodException)
    }
}

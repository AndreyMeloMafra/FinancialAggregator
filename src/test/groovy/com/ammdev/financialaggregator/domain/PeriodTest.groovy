package com.ammdev.financialaggregator.domain

import com.ammdev.financialaggregator.exception.DateRangePeriodException
import com.ammdev.financialaggregator.exception.InvalidDatePeriodException
import com.ammdev.financialaggregator.exception.InvalidStringDateException
import spock.lang.Specification

class PeriodTest extends Specification {
    def "Deve lançar uma exception quando o periodo for vazio"() {
        given: "Um periodo para filtrar"
        String startDate = start
        String endDate = end

        when: "Criar um periodo"
        Period period = new Period(startDate, endDate)

        and: "O periodo não deve ser criado"
        period == null

        then: "Deve lançar uma exception de periodo inválido"
        def exception = thrown(InvalidDatePeriodException)

        and: "a mensagem deve ser a esperada"
        exception.getError().detail() == Constants.INVALID_DATE_PERIOD_EXCEPTION_DETAIL

        where: "as datas são"
        scenario            | start         | end
        "ambas são vazias"  | ""            | ""
        "inicial é vazia"   | ""            | "2025-02-25"
        "final é vazia"     | "2025-02-25"  | ""
        "ambas são nulas"   | null          | null
        "inicial é nula"    | null          | "2025-02-25"
        "final é nula"      | "2025-02-25"  | null
    }

    def "Deve lançar uma exception quando o periodo for inválido"() {
        given: "Um periodo para filtrar"
        String startDate = start
        String endDate = end

        when: "Criar um periodo"
        Period period = new Period(startDate, endDate)

        and: "O periodo não deve ser criado"
        period == null

        then: "Deve lançar uma exception de periodo inválido"
        def exception = thrown(InvalidStringDateException)

        and: "a mensagem deve ser a esperada"
        exception.getError().detail() == Constants.INVALID_STRING_DATE_EXCEPTION_DETAIL

        where: "as datas são"
        scenario                | start         | end
        "ambas são inválidas"   | "2025-02-311" | "2025-03-311"
        "inicial é inválidas"   | "2025-03-311" | "2025-02-25"
        "final é inválidas"     | "2025-02-25"  | "2025-03-311"
    }

    def "Deve lançar uma exception quando a data de inicio for maior que a data de fim"() {
        given: "Um periodo para filtrar"
        String startDate = "2021-01-01"
        String endDate = "2020-01-01"

        when: "Criar um periodo"
        Period period = new Period(startDate, endDate)

        and: "O periodo não deve ser criado"
        period == null

        then: "Deve lançar uma exception de periodo inválido"
        thrown(DateRangePeriodException)
    }
}

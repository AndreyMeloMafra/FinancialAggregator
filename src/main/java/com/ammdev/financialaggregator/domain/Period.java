package com.ammdev.financialaggregator.domain;

import com.ammdev.financialaggregator.exception.DateRangePeriodException;
import com.ammdev.financialaggregator.exception.InvalidDatePeriodException;
import com.ammdev.financialaggregator.exception.InvalidStringDateException;
import com.ammdev.financialaggregator.utils.DateUtils;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;

public record Period(String startDate, String endDate) {
    public Period {
        if (ObjectUtils.isEmpty(startDate) || ObjectUtils.isEmpty(endDate)) {
            throw new InvalidDatePeriodException(Constants.INVALID_DATE_PERIOD_EXCEPTION_DETAIL);
        }

        if (!startDate.matches(Constants.DATE_PATTERN) || !endDate.matches(Constants.DATE_PATTERN)) {
            throw new InvalidStringDateException(Constants.INVALID_STRING_DATE_EXCEPTION_DETAIL);
        }

        LocalDate localDateStartDate = DateUtils.parseStringDate(startDate);
        LocalDate localDateEndDate = DateUtils.parseStringDate(endDate);

        if (localDateStartDate.isAfter(localDateEndDate)) {
            throw new DateRangePeriodException(Constants.DATE_RANGE_PERIOD_EXCEPTION_DETAIL);
        }
    }
}

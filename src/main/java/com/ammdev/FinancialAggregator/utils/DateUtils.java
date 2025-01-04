package com.ammdev.FinancialAggregator.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {

    public static LocalDate parseStringDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return LocalDate.parse(date, formatter);
    }

    public static boolean isDateBetween(String date, String startDate, String endDate) {
        LocalDate localDate = parseStringDate(date);
        LocalDate localStartDate = parseStringDate(startDate);
        LocalDate localEndDate = parseStringDate(endDate);
        return localDate.isAfter(localStartDate) && localDate.isBefore(localEndDate);
    }
}

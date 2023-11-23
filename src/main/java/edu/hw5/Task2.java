package edu.hw5;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;

public final class Task2 {
    private Task2() {}

    public static List<LocalDate> getAllFridays(int year) {
        LocalDate current = LocalDate.of(year, 1, 1);
        List<LocalDate> fridays = new ArrayList<>();

        LocalDate date = getNextFriday(current);
        while (date.getYear() == year) {
            fridays.add(date);
            date = getNextFriday(date);
        }
        return fridays;
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    public static LocalDate getNextFriday(LocalDate current) {
        LocalDate friday = current.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));
        while (friday.getDayOfMonth() != 13) {
            friday = friday.plus(7, ChronoUnit.DAYS);
        }
        return friday;
    }

 }

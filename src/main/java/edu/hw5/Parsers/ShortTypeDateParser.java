package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public class ShortTypeDateParser extends DateParse {
    static String pattern = "\\d{1,2}/\\d{1,2}/\\d{1,4}";

    @Override
    public Optional<LocalDate> parse(String date) {
        if (date == null || !date.matches(pattern)) {
            return parseNext(date);
        }

        String[] parseDate = date.split("/");
        int day = Integer.parseInt(parseDate[0]);
        int month = Integer.parseInt(parseDate[1]);
        int year = Integer.parseInt(parseDate[2]);

        return Optional.of(LocalDate.of(year, month, day));
    }
}

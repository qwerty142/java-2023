package edu.hw5.Parsers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public class DayAndNumParser extends DateParse {
    static String pattern = "\\d+ (days|weeks|months|years) (ago|after)";

    @Override
    public Optional<LocalDate> parse(String date) {
        if (date == null || !date.matches(pattern)) {
            return parseNext(date);
        }

        String[] parseArray = date.split(" ");
        int i = Integer.parseInt(parseArray[0]);
        String name = parseArray[1];
        TemporalUnit unit = switch (name) {
            case "days" -> ChronoUnit.DAYS;
            case "months" -> ChronoUnit.MONTHS;
            case "weeks" -> ChronoUnit.WEEKS;
            case "years" -> ChronoUnit.YEARS;
            default -> throw new IllegalArgumentException();
        };

        String way = parseArray[2];
        Optional<LocalDate> localDate;
        return switch (way) {
            case "after" -> Optional.of(LocalDate.now().plus(i, unit));
            case "ago" -> Optional.of(LocalDate.now().minus(i, unit));
            default -> throw new IllegalArgumentException();
        };
    }
}

package edu.hw5.Parsers;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Optional;

public final class DayAndNumParser {
    private DayAndNumParser() {}

    static String pattern = "\\d+ (days|weeks|months|years) (ago|after)";

    public static ParseResult tryParseDayAndNumString(ParseResult result) {
        if (result.parseResult() || !result.date().matches(pattern)) {
            return result;
        }

        String[] parseArray = result.date().split(" ");
        int i = Integer.parseInt(parseArray[0]);
        String name = parseArray[1];
        TemporalUnit unit = switch (name) {
            case "days" -> ChronoUnit.DAYS;
            case "months" -> ChronoUnit.MONTHS;
            case "weeks" -> ChronoUnit.WEEKS;
            case "years" -> ChronoUnit.YEARS;
            default -> ChronoUnit.valueOf(name);
        };

        String way = parseArray[2];
        Optional<LocalDate> localDate;
        switch (way) {
            case "after":
                localDate = Optional.of(LocalDate.now().plus(i, unit));
                break;
            case "ago":
                localDate = Optional.of(LocalDate.now().minus(i, unit));
                break;
            default:
                localDate = result.res();
        }

        return new ParseResult(result.date(), localDate, true);
    }
}

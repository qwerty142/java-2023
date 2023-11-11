package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public final class ShortTypeDateParser {
    private ShortTypeDateParser() {}

    static Pattern pattern = Pattern.compile("\\d{1,2}/\\d{1,2}/\\d{1,4}");

    public static ParseResult tryParseShort(ParseResult result) {
        if (result.parseResult() || !pattern.matcher(result.date()).matches()) {
            return result;
        }

        String[] parseDate = result.date().split("/");
        int day = Integer.parseInt(parseDate[0]);
        int month = Integer.parseInt(parseDate[1]);
        int year = Integer.parseInt(parseDate[2]);

        return new ParseResult(result.date(), Optional.of(LocalDate.of(year, month, day)), true);
    }
}

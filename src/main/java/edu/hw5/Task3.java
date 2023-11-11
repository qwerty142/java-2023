package edu.hw5;

import edu.hw5.Parsers.DayAndNumParser;
import edu.hw5.Parsers.ParseResult;
import edu.hw5.Parsers.ShortTypeDateParser;
import edu.hw5.Parsers.StandardDateParser;
import edu.hw5.Parsers.StringDateParser;
import java.time.LocalDate;
import java.util.Optional;

public final class Task3 {
    private Task3() {}

    public static Optional<LocalDate> parseDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }
        LocalDate localDate;
        ParseResult result = new ParseResult(date, Optional.empty(), false);
        result = DayAndNumParser.tryParseDayAndNumString(result);
        result = ShortTypeDateParser.tryParseShort(result);
        result = StandardDateParser.tryStandardParse(result);
        result = StringDateParser.tryParseString(result);

        if (!result.parseResult()) {
            return Optional.empty();
        }
        return result.res();
    }
}

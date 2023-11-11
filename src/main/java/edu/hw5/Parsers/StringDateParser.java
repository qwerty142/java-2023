package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public final class StringDateParser {
    private StringDateParser() {}

    static Optional<LocalDate> tomorrow = Optional.of(LocalDate.now().plusDays(1));
    static Optional<LocalDate> today = Optional.of(LocalDate.now());
    static Optional<LocalDate> yesterday = Optional.of(LocalDate.now().minusDays(1));

    @SuppressWarnings("checkstyle:ReturnCount")
    public static ParseResult tryParseString(ParseResult result) {
        if (result.parseResult()) {
            return result;
        }
        switch (result.date()) {
            case "tomorrow":
                return new ParseResult(result.date(), tomorrow, true);
            case "today":
                return new ParseResult(result.date(), today, true);
            case "yesterday":
                return new ParseResult(result.date(), yesterday, true);
            default:
                return result;
        }
    }
}

package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;
import java.util.regex.Pattern;

public final class StandardDateParser {
    private StandardDateParser() {}

    static Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");

    public static ParseResult tryStandardParse(ParseResult result) {
        if (!pattern.matcher(result.date()).matches()) {
            return result;
        }
        return new ParseResult(result.date(), Optional.of(LocalDate.parse(result.date())), true);
    }
}

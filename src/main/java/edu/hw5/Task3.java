package edu.hw5;

import edu.hw5.Parsers.DateParse;
import edu.hw5.Parsers.DayAndNumParser;
import edu.hw5.Parsers.ShortTypeDateParser;
import edu.hw5.Parsers.StandardDateParser;
import edu.hw5.Parsers.StringDateParser;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public final class Task3 {
    private Task3() {}

    public static Optional<LocalDate> parseDate(String date) {
        if (date == null) {
            throw new IllegalArgumentException();
        }

        DateParse dateParse = DateParse.createChain(new DayAndNumParser(), List.of(
            new ShortTypeDateParser(),
            new StandardDateParser(),
            new StringDateParser()));

        return dateParse.parse(date);
    }
}

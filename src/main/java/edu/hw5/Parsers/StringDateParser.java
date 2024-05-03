package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public class StringDateParser extends DateParse {

    static Optional<LocalDate> tomorrow = Optional.of(LocalDate.now().plusDays(1));
    static Optional<LocalDate> today = Optional.of(LocalDate.now());
    static Optional<LocalDate> yesterday = Optional.of(LocalDate.now().minusDays(1));

    @SuppressWarnings("checkstyle:ReturnCount")
    @Override
    public Optional<LocalDate> parse(String date) {
        if (date == null) {
            return Optional.empty();
        }
        return switch (date) {
            case "tomorrow" -> tomorrow;
            case "today" -> today;
            case "yesterday" -> yesterday;
            default -> parseNext(date);
        };
    }
}

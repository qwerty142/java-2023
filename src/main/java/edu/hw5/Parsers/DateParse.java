package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public abstract class DateParse {
    private DateParse next;

    public static DateParse createChain(DateParse firstElem, List<DateParse> dateParses) {
        DateParse first = firstElem;
        for (DateParse nextChainElem : dateParses) {
            first.next = nextChainElem;
            first = nextChainElem;
        }
        return firstElem;
    }

    public abstract Optional<LocalDate> parse(String date);

    public Optional<LocalDate> parseNext(String date) {
        if (next == null) {
            return Optional.empty();
        }
        return next.parse(date);
    }
}

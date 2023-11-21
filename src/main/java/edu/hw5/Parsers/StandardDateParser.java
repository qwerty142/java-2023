package edu.hw5.Parsers;

import javax.swing.text.DateFormatter;
import java.time.LocalDate;
import java.util.Optional;

public class StandardDateParser extends DateParse {

    static String pattern = "\\d{1,4}-\\d{1,2}-\\d{1,2}";

    @Override
    public Optional<LocalDate> parse(String date) {
        if (date == null || !date.matches(pattern)) {
            return parseNext(date);
        }
        int index = date.lastIndexOf("-");
        String[] dateFormater = date.split("-");

        // Это не самое оптимальное, но явно более читаемо чем возьня с индексами
        return Optional.of(
            LocalDate.of(
                Integer.parseInt(dateFormater[0]),
                Integer.parseInt(dateFormater[1]),
                Integer.parseInt(dateFormater[2])
            )
        );
    }
}

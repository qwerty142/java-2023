package edu.hw5;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Pattern;

public final class Task1 {
    private static Pattern inputPattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2}, \\d{2}:\\d{2}");

    private Task1() {}

    @SuppressWarnings("checkstyle:MultipleStringLiterals")
    public static String countTime(List<String> inputDates) {
        if (inputDates == null || inputDates.isEmpty()) {
            throw new IllegalArgumentException();
        }
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm");
        Duration res = Duration.ZERO;
        for (var string : inputDates) {
            String[] strings = string.split(" - ");
            if (!inputPattern.matcher(strings[0]).matches()
                || !inputPattern.matcher(strings[1]).matches()) {
                throw new IllegalArgumentException("incorrect input");
            }

            LocalDateTime start = LocalDateTime.parse(strings[0], dateTimeFormatter);
            LocalDateTime end = LocalDateTime.parse(strings[1], dateTimeFormatter);
            res = res.plus(Duration.between(start, end));
        }
        res = res.dividedBy(inputDates.size());
        return res.toString().replaceFirst("H", "ч ").replaceFirst("M", "м").replaceFirst("PT", "");
    }
}

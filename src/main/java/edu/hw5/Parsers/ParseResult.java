package edu.hw5.Parsers;

import java.time.LocalDate;
import java.util.Optional;

public record ParseResult(String date, Optional<LocalDate> res, boolean parseResult) {
}

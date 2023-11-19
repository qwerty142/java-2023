package edu.project3.Servisies;

import edu.project3.Models.Config;
import java.time.LocalDate;

public final class InputFlagsParser {
    private InputFlagsParser() {}

    public static Config parseArguments(String args) {
        String[] arguments = args.split(" ");
        Config config = new Config();

        String flag = "";
        for (var argument : arguments) {
            if (argument.startsWith("-")) {
                flag = argument;
                continue;
            }
            switch (flag) {
                case "-path" -> config.setPath(argument);
                case "-from" -> config.setStartDate(LocalDate.parse(argument));
                case "-to" -> config.setEndDate(LocalDate.parse(argument));
                case "-format" -> config.setOutput(argument);
                default -> {
                    continue;
                }
            }
        }
        return config;
    }
}

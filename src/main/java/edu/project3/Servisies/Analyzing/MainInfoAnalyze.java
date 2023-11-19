package edu.project3.Servisies.Analyzing;

import edu.project3.Entities.Log;
import edu.project3.Models.Config;
import edu.project3.Models.TableCreater;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MainInfoAnalyze implements Analyzer {
    private Config config;

    public MainInfoAnalyze(Config config) {
        this.config = config;
    }

    @Override
    public TableCreater analyze(List<Log> logs) throws IOException {
        TableCreater tableResult = new TableCreater("General information", List.of("Metrics", "Value"));
        List<String> files = config.getFiles();
        for (String file : files) {
            String fileName = file.substring(
                Math.max(
                    file.lastIndexOf('\\'),
                    file.lastIndexOf('/')
                ) + 1
            );
            tableResult.addRow(List.of(
                "Files",
                '`' + fileName + '`'
            ));
        }
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        tableResult.addRow(List.of(
            "Start date",
            config.start == LocalDate.MIN ? "-" : config.start.format(format)
        ));
        tableResult.addRow(List.of(
            "End date",
            config.end == LocalDate.MAX ? "-" : config.end.format(format)
        ));
        tableResult.addRow(List.of(
            "Requests amount",
            String.valueOf(logs.size())
        ));
        tableResult.addRow(List.of(
            "Average body size",
            String.valueOf(
                (long) logs.stream()
                    .mapToLong(Log::)
                    .average()
                    .orElse(0)
            ) + 'b'
        ));
        return tableResult;
    }
}

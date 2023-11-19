package edu.project3.Servisies;

import edu.project3.Entities.Log;
import edu.project3.Models.Config;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LogGetter {
    private LogGetter() {}

    public List<Log> getFromConf(Config config) throws IOException {
        List<String> logs = new ArrayList<>();
        if (config.path.startsWith("http")) {
            logs = fetch(config.path);
        } else {
            for (String path : config.getFiles()) {
                try {
                    logs.addAll(Files.readAllLines(Path.of(path)));
                } catch (IOException ignored) {
                }
            }
        }
        return parseStrings(logs, config);
    }

    @SuppressWarnings("checkstyle:MagicNumber")
    private List<String> fetch(String path) {
        try (HttpClient client = HttpClient.newBuilder().build()) {
            var request = HttpRequest.newBuilder()
                .uri(URI.create(path))
                .timeout(Duration.ofSeconds(20))
                .GET()
                .build();
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return Arrays.stream(response.body().split("\n")).toList();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static List<Log> parseStrings(List<String> logInString, Config config) {
        List<Log> logs = new ArrayList<>();
        for (String line : logInString) {
            Log res = Log.createLog(line);
            if (res.time.toLocalDate().isAfter(config.start)
                && res.time.toLocalDate().isBefore(config.end)) {
                logs.add(res);
            }
        }
        return logs;
    }
}

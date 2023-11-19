package edu.project3.Models;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Config {
    public String path = "";
    public LocalDate start = LocalDate.MIN;
    public LocalDate end = LocalDate.MAX;
    public String outputType = "markdown";

    public Config(String path) {
        this.path = path;
    }

    public Config(String path, LocalDate start, LocalDate end) {
        this.path = path;
        this.start = start;
        this.end = end;
    }

    public Config(String path, String outputType) {
        this.path = path;
        this.outputType = outputType;
    }

    public Config(String path, LocalDate start, LocalDate end, String outputType) {
        this.path = path;
        this.start = start;
        this.end = end;
        this.outputType = outputType;
    }

    public Config() {
    }

    public Config setPath(String path) {

        return new Config(path, start, end, outputType);
    }

    public Config setStartDate(LocalDate start) {

        return new Config(path, start, end, outputType);
    }

    public Config setEndDate(LocalDate end) {
        if (end.compareTo(start) != 1) {
            throw new IllegalArgumentException();
        }
        return new Config(path, start, end, outputType);
    }

    public Config setOutput(String outputType) {

        return new Config(path, start, end, outputType);
    }

    @SuppressWarnings("checkstyle:HiddenField")
    public List<String> getFiles() throws IOException {
        if (path.startsWith("http")) {
            return List.of();
        }

        Path way = Path.of(System.getProperty("user.dir"));
        String startString = path
            .substring(0, path.indexOf('*') == -1
                ? path.length()
                : path.indexOf('*')
            );

        Path start = Path.of(startString);
        if (!startString.isEmpty() && path.indexOf('*') != -1 && !startString.endsWith("\\")) {
            start = start.getParent();
        }

        Visitor finder = new Visitor(path);
        if (!start.isAbsolute()) {
            finder = new Visitor(way + "/" + path);
        }

        way = way.resolve(start);

        Files.walkFileTree(way, finder);
        return finder.files;
    }

    private static class Visitor extends SimpleFileVisitor<Path> {
        private final PathMatcher matcher;
        private final List<String> files = new ArrayList<>();

        Visitor(String pattern) {
            matcher = FileSystems.getDefault()
                .getPathMatcher("glob:" + pattern.replaceAll("\\\\", "/"));
        }

        void check(Path file) {
            if (file != null && matcher.matches(file)) {
                files.add(file.toString());
            }
        }

        @Override
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
            check(dir);
            if (Files.isReadable(dir)) {
                return super.preVisitDirectory(dir, attrs);
            }
            return FileVisitResult.SKIP_SIBLINGS;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            check(file);
            return super.visitFile(file, attrs);
        }

        @Override
        public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
            return FileVisitResult.SKIP_SUBTREE;
        }
    }
}

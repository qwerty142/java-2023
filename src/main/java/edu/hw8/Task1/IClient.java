package edu.hw8.Task1;

public interface IClient extends AutoCloseable {
    void start();

    void close();

    String send(String message);
}

package edu.hw2.Task3.ConnectionTypes;

public interface Connection extends AutoCloseable {
    void execute(String command);
}

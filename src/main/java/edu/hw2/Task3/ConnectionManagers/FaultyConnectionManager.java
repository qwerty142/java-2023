package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.ConnectionTypes.Connection;
import edu.hw2.Task3.ConnectionTypes.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    private final int errorStatus;

    public FaultyConnectionManager(int errorStatus) {
        this.errorStatus = errorStatus;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(errorStatus);
    }
}

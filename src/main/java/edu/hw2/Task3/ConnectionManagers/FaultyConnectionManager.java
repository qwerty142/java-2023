package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.ConnectionTypes.Connection;
import edu.hw2.Task3.ConnectionTypes.FaultyConnection;

public class FaultyConnectionManager implements ConnectionManager {
    private final boolean luckStatus;

    public FaultyConnectionManager(boolean luckStatus) {
        this.luckStatus = luckStatus;
    }

    @Override
    public Connection getConnection() {
        return new FaultyConnection(luckStatus);
    }
}

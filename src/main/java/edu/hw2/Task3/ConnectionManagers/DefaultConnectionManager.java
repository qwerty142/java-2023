package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.ConnectionTypes.Connection;
import edu.hw2.Task3.ConnectionTypes.FaultyConnection;
import edu.hw2.Task3.ConnectionTypes.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int[] MASSIVE_FOR_RANDOM = new int[] {5, 2, 3, 4, 1, 8};
    private final Random random;
    private final int errorConnectionValue;
    private final double errorCheck;

    public DefaultConnectionManager(int errorConnectionValue, double errorCheck) {
        if (errorCheck > 1 || errorCheck < 0) {
            throw new IllegalArgumentException();
        }
        this.errorConnectionValue = errorConnectionValue;
        this.errorCheck = errorCheck;
        random = new Random();
    }

    @Override
    public Connection getConnection() {
        double randomNumber = random.nextDouble();
        if (errorCheck > randomNumber) {
            return new FaultyConnection(errorConnectionValue);
        }
        return new StableConnection();
    }
}

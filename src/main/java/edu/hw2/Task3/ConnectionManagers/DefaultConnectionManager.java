package edu.hw2.Task3.ConnectionManagers;

import edu.hw2.Task3.ConnectionTypes.Connection;
import edu.hw2.Task3.ConnectionTypes.FaultyConnection;
import edu.hw2.Task3.ConnectionTypes.StableConnection;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    private static final int[] MASSIVEFORRANDOM = new int[] {5, 2, 3, 4, 1, 8};
    private final Random random;

    public DefaultConnectionManager() {
        random = new Random();
    }

    @Override
    public Connection getConnection() {
        int randomIndex = random.nextInt(MASSIVEFORRANDOM.length);
        int randomIndexFroFaultyConnection = random.nextInt(MASSIVEFORRANDOM.length);

        return MASSIVEFORRANDOM[randomIndex] % 2 == 1 ? new FaultyConnection(
            randomIndexFroFaultyConnection % 2 == 0)
            :
            new StableConnection();
    }
    // Случайность невозможно тестировать так что для этого нужна отдельная функция

    public Connection getConnection(boolean checkForTests) {
        int randomIndex = random.nextInt(MASSIVEFORRANDOM.length);
        int randomIndexFroFaultyConnection = random.nextInt(MASSIVEFORRANDOM.length);

        return !checkForTests ? new FaultyConnection(
            randomIndexFroFaultyConnection % 2 == 0)
            :
            new StableConnection();
    }
}

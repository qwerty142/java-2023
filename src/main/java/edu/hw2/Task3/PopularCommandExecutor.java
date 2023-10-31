package edu.hw2.Task3;

import edu.hw2.Task3.ConnectionManagers.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    private final Logger logger;
    public boolean workDone = false;

    public PopularCommandExecutor(ConnectionManager connectionManager, int maxAttempts) {
        manager = connectionManager;
        this.maxAttempts = maxAttempts;
        logger = LogManager.getLogger();
    }

    public void updatePackages() throws Exception {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) throws Exception {
        for (int i = 0; i < maxAttempts; i++) {
            try (var connection = manager.getConnection()) {
                connection.execute(command);
                break;
            } catch (Exception exception) {
                logger.trace("Error while trying to connect");
            }
        }
        workDone = true;
    }
}

package edu.hw2.Task3.ConnectionTypes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StableConnection implements Connection {
    private static Logger logger;

    public StableConnection() {
        logger = LogManager.getLogger();
    }

    @Override
    public void close() throws Exception {
        logger.trace("Stable connection stopped");
    }

    @Override
    public void execute(String command) {
        if (command == null) {
            throw new IllegalArgumentException("command must be not null");
        }
        logger.trace("Stable connection executed", command);
    }
}

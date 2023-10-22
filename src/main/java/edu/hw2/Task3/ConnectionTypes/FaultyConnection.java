package edu.hw2.Task3.ConnectionTypes;

import edu.hw2.Task3.Exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final boolean luckStatus;
    private static Logger logger;

    public FaultyConnection(boolean luckStatus) {
        this.luckStatus = luckStatus;
        logger = LogManager.getLogger();
    }

    @Override
    public void execute(String command) {
        if (command == null) {
            throw new IllegalArgumentException("command must be not null");
        }
        if (!luckStatus) {
            throw new ConnectionException("Fatal try to connect");
        }
        logger.trace("Stable connection executed", command);
    }

    @Override
    public void close() throws Exception {
        logger.trace("Connection stopped");
    }
}

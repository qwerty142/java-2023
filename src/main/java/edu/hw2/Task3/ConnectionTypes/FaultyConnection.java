package edu.hw2.Task3.ConnectionTypes;

import edu.hw2.Task3.Exception.ConnectionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FaultyConnection implements Connection {
    private final int errorStatus;
    private static final int COEFFICIENT_FOR_CHECK_ERRORS = 2;
    private static final int COEFFICIENT_FOR_CHECK_ATTEMPTS = 5;
    private static int attempts = 0;
    private static Logger logger;

    public FaultyConnection(int errorStatus) {
        this.errorStatus = errorStatus;
        logger = LogManager.getLogger();
    }

    @Override
    public void execute(String command) {
        attempts += 1;
        if (command == null) {
            throw new IllegalArgumentException("command must be not null");
        }
        if (errorStatus % COEFFICIENT_FOR_CHECK_ERRORS == 1 && attempts % COEFFICIENT_FOR_CHECK_ATTEMPTS == 1) {
            throw new ConnectionException("Fatal try to connect");
        }
        logger.trace("Stable connection executed", command);
    }

    @Override
    public void close() throws Exception {
        logger.trace("Connection stopped");
    }
}

package edu.project1;

import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MessageLogger {
    protected final Logger logger = LogManager.getLogger();
    protected final Scanner scanner = new Scanner(System.in);

    public String getMessage(String message) {
        if (message.length() == 0) {
            return scanner.hasNext() ? scanner.nextLine() : "";
        }
        return message;
    }

    public void writeMessage(String message) {
        if (message == null) {
            logger.error("Output string cant be null");
        }
        logger.trace(message);
    }
}

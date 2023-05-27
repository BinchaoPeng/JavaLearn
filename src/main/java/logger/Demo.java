package logger;

import java.util.logging.Logger;

public class Demo {
    public static void main(String[] args) {
        Logger logger = Logger.getGlobal();

        logger.info("start process...");
        logger.warning("memory is running out...");
        logger.fine("ignored.");
        logger.severe("process will be terminated...");
    }

}

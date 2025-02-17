package utils;

import org.slf4j.Logger;
import utils.Listners.ExtentListeners;

public class Commons {
    /**
     * Common logging method
     * @param message
     * @param log
     */
    public static void logsReporter(String message, Logger log){
        log.info(message);
        ExtentListeners.testReport.get().info(message);
    }
}

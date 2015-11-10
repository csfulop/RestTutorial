
package hu.fcs.ratina.tutorial.GuiceTutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InMemoryTransactionLog implements TransactionLog {

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryTransactionLog.class);

    public void logChargeResult(ChargeResult result) {
        LOGGER.info("charging... result={}, message={}", result.wasSuccessful(), result.getDeclineMessage());
    }

    public void logConnectException(Exception e) {
        LOGGER.info("connection exception: {}", e.getMessage());
    }

}

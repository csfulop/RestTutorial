
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

@Singleton
public class EmailMessageService implements MessageService {

    private static Logger LOGGER = LoggerFactory.getLogger(MessageService.class);

    @Override
    public boolean send(String recipient, String message) {
        LOGGER.info("Email message to {}: {}", recipient, message);
        LOGGER.info("EmailMessageService id: {}", hashCode());
        return true;
    }

}


package hu.fcs.ratina.tutorial.GuiceTutorial2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Singleton;

@Singleton
public class FacebookMessageService implements MessageService {

    private static Logger LOGGER = LoggerFactory.getLogger(FacebookMessageService.class);

    @Override
    public boolean send(String recipient, String message) {
        LOGGER.info("Facebook message to {}: {}", recipient, message);
        LOGGER.info("FacebookMessageService id: {}", hashCode());
        return true;
    }

}

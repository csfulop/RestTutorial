
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Provider;

public class EmailMessageServiceProvider implements Provider<EmailMessageService> {

    private static Logger LOGGER = LoggerFactory.getLogger(EmailMessageServiceProvider.class);

    @Override
    public EmailMessageService get() {
        LOGGER.info("Creating EmailMessageService...");
        EmailMessageService service = new EmailMessageService();
        // set optional parameters, credetials, server, etc...
        return service;
    }

}

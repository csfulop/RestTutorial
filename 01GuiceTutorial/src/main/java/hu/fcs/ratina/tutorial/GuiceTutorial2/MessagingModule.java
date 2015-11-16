
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Names;

public class MessagingModule extends AbstractModule {

    private static Logger LOGGER = LoggerFactory.getLogger(MessagingModule.class);

    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailMessageService.class);
        bind(MessageService.class).annotatedWith(Facebook.class).to(FacebookMessageService.class);
        bind(MessageService.class).annotatedWith(Names.named("Facebook")).to(FacebookMessageService.class);
        // bind(EmailMessageService.class).toProvider(EmailMessageServiceProvider.class).in(Singleton.class);
    }

    @Provides
    FacebookMessageService provideFacebookService() {
        LOGGER.info("Creating FacebookMessageService...");
        FacebookMessageService service = new FacebookMessageService();
        // set optional parameters, credetials, server, etc...
        return service;
    }

}


package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class MessagingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailMessageService.class);
        bind(MessageService.class).annotatedWith(Facebook.class).to(FacebookMessageService.class);
        bind(MessageService.class).annotatedWith(Names.named("Facebook")).to(FacebookMessageService.class);
    }

}

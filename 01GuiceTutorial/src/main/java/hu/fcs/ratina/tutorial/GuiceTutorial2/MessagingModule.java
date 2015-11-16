
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.AbstractModule;

public class MessagingModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(MessageService.class).to(EmailMessageService.class);
    }

}

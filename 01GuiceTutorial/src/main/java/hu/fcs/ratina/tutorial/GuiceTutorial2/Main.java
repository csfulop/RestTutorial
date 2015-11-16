
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MessagingModule());
        MessageService messageService = injector.getInstance(MessageService.class);
        messageService.send("csaba.fulop@nokia.com", "Hello World!");
    }

}

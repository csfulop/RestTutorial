
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new MessagingModule());
        MyApp myApp = injector.getInstance(MyApp.class);
        myApp.notifyUser("csaba.fulop@nokia.com");

        MessageService messageService = injector.getInstance(FacebookMessageService.class);
        messageService.send("csaba.fulop@nokia.com", "Hello World!");
    }

}

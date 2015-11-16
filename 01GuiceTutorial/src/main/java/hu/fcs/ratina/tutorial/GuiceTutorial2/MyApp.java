
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.Inject;

public class MyApp {

    private MessageService messageService;

    @Inject
    public MyApp(FacebookMessageService messageService) {
        this.messageService = messageService;
    }

    public void notifyUser(String user) {
        messageService.send(user, "New version of MyApp is available");
    }

}

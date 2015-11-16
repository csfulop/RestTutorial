
package hu.fcs.ratina.tutorial.GuiceTutorial2;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class MyApp {

    private Provider<MessageService> provider;

    @Inject
    public MyApp(@Facebook Provider<MessageService> provider) {
        this.provider = provider;
    }

    public void notifyUser(String user) {
        provider.get().send(user, "New version of MyApp is available");
    }

}

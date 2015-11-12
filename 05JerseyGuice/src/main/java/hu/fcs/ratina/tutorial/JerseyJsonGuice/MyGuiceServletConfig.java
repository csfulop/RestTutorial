
package hu.fcs.ratina.tutorial.JerseyJsonGuice;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.spi.container.servlet.ServletContainer;

public class MyGuiceServletConfig extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(ServletContainer.class).in(Singleton.class);
                Map<String, String> params = new HashMap<>();
                params.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
                params.put("com.sun.jersey.config.property.packages", "hu.fcs.ratina.tutorial.JerseyJsonGuice");
                serve("/rest/*").with(ServletContainer.class);
            }
        });
    }
}

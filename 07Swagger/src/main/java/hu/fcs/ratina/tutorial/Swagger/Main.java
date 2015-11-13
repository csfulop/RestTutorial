
package hu.fcs.ratina.tutorial.Swagger;

import java.util.HashMap;
import java.util.Map;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.google.inject.servlet.GuiceServletContextListener;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class Main extends GuiceServletContextListener {

    @Override
    protected Injector getInjector() {
        return Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(Student.class);
                ResourceConfig rc =
                        new PackagesResourceConfig("hu.fcs.ratina.tutorial.Swagger");
                for (Class<?> resource : rc.getClasses()) {
                    bind(resource).in(Singleton.class);
                }
                Map<String, String> options = new HashMap<>();
                options.put("com.sun.jersey.api.json.POJOMappingFeature", "true");
                serve("/services/*").with(GuiceContainer.class, options);
            }
        });
    }
}

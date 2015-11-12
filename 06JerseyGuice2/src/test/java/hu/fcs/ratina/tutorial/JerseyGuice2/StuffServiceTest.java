
package hu.fcs.ratina.tutorial.JerseyGuice2;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.TypeLiteral;
import com.google.inject.servlet.ServletModule;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.PackagesResourceConfig;
import com.sun.jersey.api.core.ResourceConfig;
import com.sun.jersey.core.spi.component.ioc.IoCComponentProviderFactory;
import com.sun.jersey.guice.spi.container.GuiceComponentProviderFactory;

public class StuffServiceTest {

    static final URI BASE_URI = getBaseURI();
    HttpServer server;

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(9998).build();
    }

    @Before
    public void startServer() throws IOException {

        Injector injector = Guice.createInjector(new ServletModule() {
            @Override
            protected void configureServlets() {
                bind(new TypeLiteral<Dao<String>>() {}).to(StuffDao.class);
            }
        });

        ResourceConfig rc = new PackagesResourceConfig("hu.fcs.ratina.tutorial.JerseyGuice2");
        IoCComponentProviderFactory ioc = new GuiceComponentProviderFactory(rc, injector);
        server = GrizzlyServerFactory.createHttpServer(BASE_URI + "services/", rc, ioc);
    }

    @Test
    public void testGetAll() throws IOException {
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());

        ClientResponse resp = service.path("services").path("stuff")
                .accept(MediaType.TEXT_HTML)
                .get(ClientResponse.class);

        String text = resp.getEntity(String.class);

        assertEquals(200, resp.getStatus());
        assertEquals("<h2>All stuff</h2><ul>" +
                     "<li>Viola</li>" +
                     "<li>Zita</li></ul>",
                text);

    }

    @Test
    public void testGetById() throws IOException {
        Client client = Client.create(new DefaultClientConfig());
        WebResource service = client.resource(getBaseURI());

        ClientResponse resp = service.path("services")
                .path("stuff").path("1")
                .accept(MediaType.TEXT_HTML)
                .get(ClientResponse.class);

        String text = resp.getEntity(String.class);

        assertEquals(200, resp.getStatus());
        assertEquals("<html><body><div>Viola</div></body></html>", text);

        String text2 = service.path("services")
                .path("stuff").path("3")
                .accept(MediaType.TEXT_HTML)
                .get(String.class);

        assertEquals(200, resp.getStatus());
        assertEquals("<html><body><div>Not Found</div></body></html>", text2);

    }

    @After
    public void stopServer() {
        server.stop();
    }

    public static void main(String[] args) throws Exception {
        StuffServiceTest test = new StuffServiceTest();
        test.startServer();
        System.in.read(); // hit enter to stop the server
        test.server.stop();
    }

}

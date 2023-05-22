package kogito.samples.test_resource;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class TestConfigResource {
    @ConfigProperty(name = "app.config.sample-01")
    String sampleConfig01;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from RESTEasy Reactive, sampleConfig01 = " + sampleConfig01;
    }

}

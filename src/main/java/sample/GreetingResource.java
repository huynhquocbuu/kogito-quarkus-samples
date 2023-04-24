package sample;

import java.util.Map;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

import javax.ws.rs.POST;
import javax.ws.rs.Path;


import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.services.DecisionService;



@Path("/hello")
public class GreetingResource {
    // Inject the application root
    @Inject 
    AppRoot appRoot;
    // Inject a decision service
    @Inject 
    DecisionService svc;

    @POST
    //@Consumes(MediaType.APPLICATION_JSON)
    //@Produces(MediaType.APPLICATION_JSON)
    public DataContext hello(Map<String, Object> payload) {
        var id = appRoot
                .get(DecisionIds.class)
                .get("https://kiegroup.org/dmn/rest-example",
                        "PersonDecisions");
        var ctx = MapDataContext.from(payload);
        return svc.evaluate(id, ctx);
    }
}

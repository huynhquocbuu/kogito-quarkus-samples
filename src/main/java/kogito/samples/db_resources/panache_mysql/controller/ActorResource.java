package kogito.samples.db_resources.panache_mysql.controller;

import io.smallrye.mutiny.Uni;
import kogito.samples.db_resources.panache_mysql.entity.Actor;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/actor")
@Slf4j
public class ActorResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getActors() {
        log.info("-------Rest Reactive Actor getActors------");
        return Actor.getAllActors()
                .onItem().transform(actors -> Response.ok(actors))
                .onItem().transform(Response.ResponseBuilder::build);
    }
}

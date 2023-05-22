package kogito.samples.db_resources.panache_mysql.controller;

import io.smallrye.mutiny.Uni;
import kogito.samples.db_resources.panache_mysql.dto.MovieDTO;
import kogito.samples.db_resources.panache_mysql.entity.Actor;
import kogito.samples.db_resources.panache_mysql.entity.Movie;
import kogito.samples.db_resources.panache_mysql.service.MovieService;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.time.LocalDate;

@Path("/movie")
@Slf4j
public class MovieResource {
    //private MovieService movieService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> getAll() {
        log.info("-------Rest Reactive Movie getActors------");
        return Movie.getAllMovies()
                .onItem().transform(movies -> Response.ok(movies))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    @Path("add-test")
    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> addTest() {
        log.info("-------Rest Reactive Movie add test------");
        Movie movieAdd = Movie.createNew(
                "title-01",
                "Director ABC",
                LocalDate.of(2020, 1, 8));

        return Movie.addMovie(movieAdd)
                .onItem().transform(MovieDTO::from)
                .onItem().transform(entity -> Response.ok(entity))
                .onItem().transform(Response.ResponseBuilder::build);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Uni<Response> add(MovieDTO movieDTO) {
        log.info("-------Rest Reactive Movie getActors------");
        return Movie.getAllMovies()
                .onItem().transform(movies -> Response.ok(movies))
                .onItem().transform(Response.ResponseBuilder::build);
    }

}

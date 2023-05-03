package kogito.samples.db_resources.pg_reactive_db_01.controller;

import javax.annotation.PostConstruct;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import kogito.samples.db_resources.pg_reactive_db_01.entity.Movie;
import kogito.samples.db_resources.pg_reactive_db_01.repository.MoviRepository;

@Path("movies")
public class MoviController {
    private MoviRepository moviRepository;

    public MoviController(MoviRepository moviRepository){
        this.moviRepository = moviRepository;
    }

    // @PostConstruct
    // void config() {
    //     moviRepository.initdb();
    // }

    @GET
    public Multi<Movie> getAll() {
        //moviRepository.initdb();
        return moviRepository.findAll();
    }

}

package kogito.samples.db_resources.panache_mysql.service;

import io.smallrye.mutiny.Uni;
import kogito.samples.db_resources.panache_mysql.entity.Movie;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MovieServiceImpl implements MovieService{

    @Override
    //@WithTransaction
    public Uni<Movie> addMovie(Movie movie) {
        return movie.persist();
    }
}

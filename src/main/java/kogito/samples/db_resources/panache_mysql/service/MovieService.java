package kogito.samples.db_resources.panache_mysql.service;

import io.smallrye.mutiny.Uni;
import kogito.samples.db_resources.panache_mysql.entity.Movie;

public interface MovieService {
    Uni<Movie> addMovie(Movie movie);
}

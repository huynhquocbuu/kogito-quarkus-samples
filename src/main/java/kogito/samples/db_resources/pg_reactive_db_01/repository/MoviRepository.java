package kogito.samples.db_resources.pg_reactive_db_01.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.reactive.datasource.ReactiveDataSource;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.pgclient.PgPool;
import io.vertx.mutiny.sqlclient.Tuple;
import kogito.samples.db_resources.pg_reactive_db_01.entity.Movie;

@ApplicationScoped
public class MoviRepository {
    @Inject
    @ReactiveDataSource("pg_reactive_db_01")
    PgPool pgClient;

    public Multi<Movie> findAll() {
        return pgClient
                .query("SELECT id, title FROM movies ORDER BY title DESC")
                .execute()
                .onItem()
                .transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem()
                .transform(Movie::from);
    }
    
    public Uni<Movie> findById(Long id) {
        
        return pgClient
                .preparedQuery("SELECT id, title FROM movies WHERE id = $1")
                .execute(Tuple.of(id))
                .onItem()
                .transform(m -> m.iterator().hasNext() ? Movie.from(m.iterator().next()) : null);
    }

    public Uni<Long> save(String title) {
        return pgClient
                .preparedQuery("INSERT INTO movies (title) VALUES ($1) RETURNING id")
                .execute(Tuple.of(title))
                .onItem()
                .transform(m -> m.iterator().next().getLong("id"));
    }
    
    public Uni<Boolean> delete(PgPool client, Long id) {
        return pgClient
                .preparedQuery("DELETE FROM movies WHERE id = $1")
                .execute(Tuple.of(id))
                .onItem()
                .transform(m -> m.rowCount() == 1);
    }
    
    public void initdb() {
        pgClient.query("DROP TABLE IF EXISTS movies").execute()
                .flatMap(m-> pgClient.query("CREATE TABLE movies (id SERIAL PRIMARY KEY, " +
                        "title TEXT NOT NULL)").execute())
                .flatMap(m -> pgClient.query("INSERT INTO movies (title) VALUES('The Lord of the Rings')").execute())
                .flatMap(m -> pgClient.query("INSERT INTO movies (title) VALUES('Harry Potter')").execute())
                .await()
                .indefinitely();
    }
}

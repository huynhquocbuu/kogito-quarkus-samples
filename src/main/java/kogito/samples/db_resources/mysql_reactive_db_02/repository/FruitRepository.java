package kogito.samples.db_resources.mysql_reactive_db_02.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.reactive.datasource.ReactiveDataSource;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.mysqlclient.MySQLPool;
import kogito.samples.db_resources.mysql_reactive_db_02.entity.Fruit;

@ApplicationScoped
public class FruitRepository {
    @Inject
    @ReactiveDataSource("mysql_reactive_db_02")
    MySQLPool mysqlClient;

    public Multi<Fruit> findAll() {
        return mysqlClient
                .query("SELECT * FROM fruits")
                .execute()
                .onItem()
                .transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem()
                .transform(Fruit::from);
    }

}

package kogito.samples.db_resources.mysql_reactive_db_02.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import kogito.samples.db_resources.mysql_reactive_db_02.entity.Fruit;
import kogito.samples.db_resources.mysql_reactive_db_02.repository.FruitRepository;

@Path("fruits")
public class FruitController {
    private FruitRepository fruitRepository;

    public FruitController(FruitRepository fruitRepository){
        this.fruitRepository = fruitRepository;
    }

    @GET
    public Multi<Fruit> getAll() {
        //moviRepository.initdb();
        return fruitRepository.findAll();
    }
}

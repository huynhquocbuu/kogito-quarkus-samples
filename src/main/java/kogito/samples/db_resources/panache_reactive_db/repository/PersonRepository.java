package kogito.samples.db_resources.panache_reactive_db.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.reactive.panache.PanacheRepository;
import io.smallrye.mutiny.Uni;
import kogito.samples.db_resources.panache_reactive_db.entity.Person;
import kogito.samples.db_resources.panache_reactive_db.entity.Status;

@ApplicationScoped
public class PersonRepository implements PanacheRepository<Person>{
    public Uni<Person> findByName(String name){
        return find("name", name).firstResult();
    }
 
    public Uni<List<Person>> findAlive(){
        return list("status", Status.Alive);
    }
 
    public Uni<Long> deleteStefs(){
        return delete("name", "Stef");
   }
}

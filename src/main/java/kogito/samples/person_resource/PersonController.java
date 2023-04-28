package kogito.samples.person_resource;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.quarkus.panache.common.Sort;
import io.smallrye.mutiny.Uni;
import kogito.samples.databases.panache_reactive_db.entity.Person;
import kogito.samples.databases.panache_reactive_db.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;

@Path("/person")
@Slf4j
public class PersonController {
    
    private PersonRepository personRepository;
    
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @GET
    public Uni<List<Person>> get() {
        log.info("-------Reactive Person Db get all");
        return personRepository.listAll(Sort.by("name"));
    }
}

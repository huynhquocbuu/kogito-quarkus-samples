package kogito.samples.db_resources.panache_mysql.dto;

import kogito.samples.db_resources.panache_mysql.entity.Actor;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActorDTO {
    public String name;
    public Long id;

    public static ActorDTO from(Actor actor) {
        return ActorDTO
                .builder()
                .id(actor.id)
                .name(actor.name)
                .build();
    }
    public static List<ActorDTO> from(List<Actor> actor) {
        return actor.stream().map(ActorDTO::from)
                .collect(Collectors.toList());

    }
}

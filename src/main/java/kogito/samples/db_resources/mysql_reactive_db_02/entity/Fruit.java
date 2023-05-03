package kogito.samples.db_resources.mysql_reactive_db_02.entity;

import io.vertx.mutiny.sqlclient.Row;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Fruit {
    public Long id;
    public String name;

    public static Fruit from(Row row) {
        return new Fruit(row.getLong("id"), row.getString("name"));
    }
}
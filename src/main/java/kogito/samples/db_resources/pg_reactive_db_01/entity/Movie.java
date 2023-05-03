package kogito.samples.db_resources.pg_reactive_db_01.entity;

import io.vertx.mutiny.sqlclient.Row;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Long id;
    private String title;

    public static Movie from(Row row) {
        return new Movie(row.getLong("id"), row.getString("title"));
    }
}

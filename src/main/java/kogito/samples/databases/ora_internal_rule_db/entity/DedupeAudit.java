package kogito.samples.databases.ora_internal_rule_db.entity;

import java.sql.Timestamp;

import io.vertx.mutiny.sqlclient.Row;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DedupeAudit {
    private String requestId;
    private String systemRequest;
    //private Timestamp requestAt;
    private String appId;
    private String identifyNumbers;
    private String phoneNumbers;
    private String decision;
    private String reason;
    private String description;

    public static DedupeAudit from(Row row) {
        return DedupeAudit
        .builder()
        .requestId(row.getString("request_id"))
        .systemRequest(row.getString("system_request"))
        //.requestAt(row.get(Timestamp.class, "request_at"))
        .appId(row.getString("app_id"))
        .identifyNumbers(row.getString(""))
        .phoneNumbers(row.getString("phone_numbers"))
        .decision(row.getString("decision"))
        .description(row.getString("description"))
        .build();
    }
}

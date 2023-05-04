package kogito.samples.db_resources.ora_internal_rule.entity;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import io.vertx.mutiny.sqlclient.Row;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DedupeAudit {
    private String requestId;
    private String systemRequest;
    private LocalDateTime requestAt;
 
    private String appId;
    private String identifyNumbers;
    private String phoneNumbers;
    private String decision;
    private String reason;
    private String description;

    public static DedupeAudit from(Row row) {
        return DedupeAudit.builder()
            .requestId(row.getString("request_id"))
            .systemRequest(row.getString("system_request"))
            .requestAt(row.getLocalDateTime("request_at"))
            .appId(row.getString("app_id"))
            .identifyNumbers(row.getString("identify_numbers"))
            .phoneNumbers(row.getString("phone_numbers"))
            .decision(row.getString("decision"))
            .reason(row.getString("reason"))
            .description(row.getString("description"))
            .build();
    }
}

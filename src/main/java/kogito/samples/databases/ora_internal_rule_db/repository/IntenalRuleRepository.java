package kogito.samples.databases.ora_internal_rule_db.repository;

import io.smallrye.mutiny.Multi;
import kogito.samples.databases.ora_internal_rule_db.entity.DedupeAudit;

public interface IntenalRuleRepository {
    Multi<DedupeAudit> getAllDedupeAudit();
}

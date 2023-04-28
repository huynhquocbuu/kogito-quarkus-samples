package kogito.samples.internal_rule_resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import kogito.samples.databases.ora_internal_rule_db.entity.DedupeAudit;
import kogito.samples.databases.ora_internal_rule_db.repository.IntenalRuleRepository;
import lombok.extern.slf4j.Slf4j;

@Path("/intenal-rule")
@Slf4j
public class InternalRuleController {
    private IntenalRuleRepository intenalRuleRepository;
    
    public InternalRuleController(IntenalRuleRepository intenalRuleRepository) {
        this.intenalRuleRepository = intenalRuleRepository;
    }

    @GET
    public Multi<DedupeAudit> get() {
        log.info("-------Reactive DedupeAudit Db get all");
        return intenalRuleRepository.getAllDedupeAudit();
    }
}

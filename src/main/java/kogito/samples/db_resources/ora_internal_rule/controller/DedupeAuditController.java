package kogito.samples.db_resources.ora_internal_rule.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import io.smallrye.mutiny.Multi;
import kogito.samples.db_resources.ora_internal_rule.entity.DedupeAudit;
import kogito.samples.db_resources.ora_internal_rule.repository.DedupeAuditRepository;

@Path("dedupe-audit")
public class DedupeAuditController {
    
    private DedupeAuditRepository dedupeAuditRepository;

    public DedupeAuditController(DedupeAuditRepository dedupeAuditRepository){
        this.dedupeAuditRepository = dedupeAuditRepository;
    }

    @GET
    public Multi<DedupeAudit> getAll() {
        return dedupeAuditRepository.findAll();
    }
}

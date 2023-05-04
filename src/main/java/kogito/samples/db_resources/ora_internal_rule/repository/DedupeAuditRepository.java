package kogito.samples.db_resources.ora_internal_rule.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.reactive.datasource.ReactiveDataSource;
import io.smallrye.mutiny.Multi;
import io.vertx.mutiny.oracleclient.OraclePool;
import kogito.samples.db_resources.ora_internal_rule.entity.DedupeAudit;

@ApplicationScoped
public class DedupeAuditRepository {
    @Inject
    @ReactiveDataSource("ora_internal_rule")
    OraclePool oraClient;

    public void test(){

    }
    
    public Multi<DedupeAudit> findAll() {
        return oraClient
                .query("SELECT * FROM dedupe_audit")
                .execute()
                .onItem()
                .transformToMulti(set -> Multi.createFrom().iterable(set))
                .onItem()
                .transform(DedupeAudit::from);
    }
}

package kogito.samples.databases.ora_internal_rule_db.repository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.reactive.datasource.ReactiveDataSource;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.oracleclient.OraclePool;
import io.vertx.mutiny.sqlclient.Row;
import io.vertx.mutiny.sqlclient.RowSet;
import kogito.samples.databases.ora_internal_rule_db.entity.DedupeAudit;

@ApplicationScoped
public class IntenalRuleRepositoryImpl implements IntenalRuleRepository{
    @Inject
    @ReactiveDataSource("internal_rule")
    OraclePool oraclePool;

    @Override
    public Multi<DedupeAudit> getAllDedupeAudit() {
        String sql = """
                SELECT * FROM dedupe_audit ORDER BY request_at DESC
            """;
        Uni<RowSet<Row>> rowSet = oraclePool.query(sql).execute();
        return rowSet
            .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
            .onItem().transform(DedupeAudit::from);
    }

    // @Override
    // public Multi<DedupeAudit> getAllDedupeAudit() {
    //     String sql = """
    //         SELECT * FROM dedupe_audit ORDER BY request_at DESC
    //             """;   
    //     Uni<RowSet<Row>> rowSet = oraclePool.query(sql).execute();
    //     return rowSet
    //             .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
    //             .onItem().transform(DedupeAudit::from);
    //     // var aaaa = rowSet
    //     //     .onItem().transformToMulti(set -> Multi.createFrom().iterable(set))
    //     //     .onItem().transform(da -> da.get(null, sql));
    // {
}

package kogito.samples.dmn_age_rule.service;

import javax.enterprise.context.ApplicationScoped;

import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.services.DecisionService;

import kogito.samples.dmn_age_rule.data.AgeRuleRequest;
import kogito.samples.dmn_age_rule.data.AgeRuleResponse;

@ApplicationScoped
public class AgeRuleServiceImpl implements AgeRuleService{
    
    private AppRoot appRoot;
    private DecisionService svc;

    public AgeRuleServiceImpl(AppRoot appRoot, DecisionService svc) {
        this.appRoot = appRoot;
        this.svc = svc;  
    }

    @Override
    public AgeRuleResponse executeRule(AgeRuleRequest input) {
        var id = appRoot
                .get(DecisionIds.class)
                .get("dmn.samples.person",
                        "PersonDecisions");
        var ctx = MapDataContext.from(input);
        var ruleOutput = svc.evaluate(id, ctx).data();
        return ruleOutput.as(AgeRuleResponse.class);
    }
    
}

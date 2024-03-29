package kogito.samples.dmn_age_rule.service;

import javax.enterprise.context.ApplicationScoped;

import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.LocalDecisionId;
import org.kie.kogito.incubation.decisions.services.DecisionService;

import kogito.samples.dmn_age_rule.converter.AgeRuleConverter;
import kogito.samples.dmn_age_rule.model.AgeRuleInput;
import kogito.samples.dmn_age_rule.model.AgeRuleOutput;

@ApplicationScoped
public class AgeRuleServiceImpl implements AgeRuleService{
    
    private AppRoot appRoot;
    private DecisionService decisionService;

    public AgeRuleServiceImpl(AppRoot appRoot, DecisionService svc) {
        this.appRoot = appRoot;
        this.decisionService = svc;  
    }

    @Override
    public AgeRuleOutput executeRule(AgeRuleInput input) {
        
        LocalDecisionId decisionId = appRoot
                .get(DecisionIds.class)
                .get("dmn.samples.person",
                        "PersonDecisions");

        DataContext ruleInput = AgeRuleConverter.toAgeRuleInput(input);
        DataContext ruleOutput = decisionService.evaluate(decisionId, ruleInput).data();                       

        return AgeRuleConverter.toAgeRuleOutput(ruleOutput);
    }
    
}

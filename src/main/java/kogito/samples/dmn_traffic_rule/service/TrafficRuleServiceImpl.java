package kogito.samples.dmn_traffic_rule.service;

import javax.enterprise.context.ApplicationScoped;

import org.kie.kogito.incubation.application.AppRoot;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.decisions.DecisionIds;
import org.kie.kogito.incubation.decisions.LocalDecisionId;
import org.kie.kogito.incubation.decisions.services.DecisionService;

import kogito.samples.dmn_traffic_rule.converter.TrafficRuleConverter;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleInput;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleOutput;

@ApplicationScoped
public class TrafficRuleServiceImpl implements TrafficRuleService{
    private AppRoot appRoot;
    private DecisionService decisionService;

    public TrafficRuleServiceImpl(AppRoot appRoot, DecisionService svc) {
        this.appRoot = appRoot;
        this.decisionService = svc;  
    }

    @Override
    public TrafficRuleOutput executeRule(TrafficRuleInput input) {

        LocalDecisionId decisionId = appRoot
                .get(DecisionIds.class)
                .get("dmn.samples.traffic",
                        "Traffic Violation");

        DataContext ruleInput = TrafficRuleConverter.toTrafficRuleInput(input);
        DataContext ruleOutput = decisionService.evaluate(decisionId, ruleInput).data();                       

        return TrafficRuleConverter.toTrafficRuleOutput(ruleOutput);
    }
}

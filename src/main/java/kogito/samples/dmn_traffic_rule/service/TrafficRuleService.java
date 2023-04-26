package kogito.samples.dmn_traffic_rule.service;

import kogito.samples.dmn_traffic_rule.model.TrafficRuleInput;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleOutput;

public interface TrafficRuleService {
    TrafficRuleOutput executeRule(TrafficRuleInput ruleInput);
}

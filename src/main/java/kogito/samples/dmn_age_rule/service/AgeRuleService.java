package kogito.samples.dmn_age_rule.service;

import kogito.samples.dmn_age_rule.payload.AgeRuleRequest;
import kogito.samples.dmn_age_rule.payload.AgeRuleResponse;

public interface AgeRuleService {
    AgeRuleResponse executeRule(AgeRuleRequest input);
}

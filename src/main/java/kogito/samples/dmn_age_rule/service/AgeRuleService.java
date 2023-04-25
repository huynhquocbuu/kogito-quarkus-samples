package kogito.samples.dmn_age_rule.service;

import kogito.samples.dmn_age_rule.data.AgeRuleRequest;
import kogito.samples.dmn_age_rule.data.AgeRuleResponse;

public interface AgeRuleService {
    AgeRuleResponse executeRule(AgeRuleRequest input);
}

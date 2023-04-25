package kogito.samples.dmn_age_rule.service;

import kogito.samples.dmn_age_rule.rulePayload.AgeRuleInput;
import kogito.samples.dmn_age_rule.rulePayload.AgeRuleOutput;

public interface AgeRuleService {
    AgeRuleOutput executeRule(AgeRuleInput input);
}

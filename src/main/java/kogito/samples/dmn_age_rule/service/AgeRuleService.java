package kogito.samples.dmn_age_rule.service;

import kogito.samples.dmn_age_rule.model.AgeRuleInput;
import kogito.samples.dmn_age_rule.model.AgeRuleOutput;

public interface AgeRuleService {
    AgeRuleOutput executeRule(AgeRuleInput input);
}

package kogito.samples.dmn_age_rule.controller;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import kogito.samples.dmn_age_rule.data.AgeRuleRequest;
import kogito.samples.dmn_age_rule.data.AgeRuleResponse;
import kogito.samples.dmn_age_rule.service.AgeRuleService;

@Path("/age-rule")
public class AgeRuleController {  
    private AgeRuleService ruleService;
    public AgeRuleController(AgeRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @POST
    public AgeRuleResponse ageRule(AgeRuleRequest request) {
        
        return ruleService.executeRule(request);
    }
}

package kogito.samples.dmn_traffic_rule.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import kogito.samples.dmn_traffic_rule.model.TrafficRuleInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficRuleRequest {
    @JsonProperty("system-request")
    private String systemRequest;
    
    @JsonProperty("rule-input")
    private TrafficRuleInput ruleInput;
}

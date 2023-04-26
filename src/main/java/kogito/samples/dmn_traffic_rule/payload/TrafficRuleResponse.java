package kogito.samples.dmn_traffic_rule.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import kogito.samples.dmn_traffic_rule.model.TrafficRuleOutput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficRuleResponse {
    
    private String status;

    @JsonProperty("error-code")
    private String errorCode;

    @JsonProperty("error-message")
    private String errorMessage;
    
    @JsonProperty("rule-output")
    private TrafficRuleOutput ruleOutput; 
}

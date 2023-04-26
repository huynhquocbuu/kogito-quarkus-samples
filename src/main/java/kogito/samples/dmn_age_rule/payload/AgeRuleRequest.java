package kogito.samples.dmn_age_rule.payload;

import com.fasterxml.jackson.annotation.JsonProperty;

import kogito.samples.dmn_age_rule.model.AgeRuleInput;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AgeRuleRequest {
    @JsonProperty("system-request")
    private String systemRequest;
    
    private AgeRuleInput input;
}

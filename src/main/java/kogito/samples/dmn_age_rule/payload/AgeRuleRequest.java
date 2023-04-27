package kogito.samples.dmn_age_rule.payload;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

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
    @NotBlank
    @Min(10)
    private String systemRequest;
    private AgeRuleInput input;
}

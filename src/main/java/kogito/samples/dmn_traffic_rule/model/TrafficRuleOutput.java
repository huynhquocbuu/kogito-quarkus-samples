package kogito.samples.dmn_traffic_rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrafficRuleOutput {
    private Fine fine;
    private String shouldBeSuspended;
}

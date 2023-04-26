package kogito.samples.dmn_traffic_rule.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrafficRuleInput {
    private Driver driver;
    private Violation violation;
}

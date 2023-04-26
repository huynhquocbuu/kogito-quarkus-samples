package kogito.samples.dmn_age_rule.model;

import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.DefaultCastable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgeRuleOutput extends AgeRuleInput implements DataContext, DefaultCastable{
    
    private boolean adult;
}
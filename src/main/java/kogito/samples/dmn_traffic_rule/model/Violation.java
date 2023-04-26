package kogito.samples.dmn_traffic_rule.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Violation {
    //private String code;
    //private LocalDateTime date;
    private String type;

    @JsonProperty("Speed Limit")
    private Number speedLimit;
    @JsonProperty("Actual Speed")
    private Number actualSpeed;
}

package kogito.samples.sample_rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleRequestModel {
    @JsonProperty("request-id")
    private String requestId;
    @JsonProperty("request-data")
    private String requestData;
}

package kogito.samples.sample_rest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleResponseModel {
    @JsonProperty("response-id")
    private String responseId;
    @JsonProperty("response-data")
    private String responseData;
}

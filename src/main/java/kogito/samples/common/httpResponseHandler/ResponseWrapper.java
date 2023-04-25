package kogito.samples.common.httpResponseHandler;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWrapper<T> {
    private String status;
    @JsonProperty("error-code")
    private String errorCode;

    @JsonProperty("error-message")
    private String errorMessage;
    private T data;

}

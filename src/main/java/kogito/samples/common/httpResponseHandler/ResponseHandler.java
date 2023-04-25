package kogito.samples.common.httpResponseHandler;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import org.jboss.resteasy.reactive.RestResponse.Status;

public class ResponseHandler {
    public static <T> RestResponse<ResponseWrapper<T>> responseOk(T data) {
        ResponseWrapper<T> wrapper = new ResponseWrapper<T>();
        wrapper.setData(data);
        wrapper.setStatus("Success");
        wrapper.setErrorCode("");
        wrapper.setErrorMessage("");

        return ResponseBuilder
            .ok(wrapper, MediaType.APPLICATION_JSON)
            .build();
    }

    public static <T> RestResponse<ResponseWrapper<T>> responseErr(T obj, String errorCode, String errorMessage)
    {
        ResponseWrapper<T> wrapper = new ResponseWrapper<T>();
        wrapper.setData(obj);
        wrapper.setStatus("Error");
        wrapper.setErrorCode(errorCode);
        wrapper.setErrorMessage(errorMessage);
        return ResponseBuilder.create(Status.BAD_REQUEST, wrapper).build();
    }

    public static RestResponse<ResponseWrapper<String>> responseInternalServerErr(String errorCode, String errorMessage)
    {
        ResponseWrapper<String> wrapper = new ResponseWrapper<>();
        wrapper.setData("");
        wrapper.setStatus("Error");
        wrapper.setErrorCode(errorCode);
        wrapper.setErrorMessage(errorMessage);
        return ResponseBuilder.create(Status.INTERNAL_SERVER_ERROR, wrapper).build();
    }

}

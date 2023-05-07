package kogito.samples.sample_rest;
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;

@Path("sample")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SampleController {
    @POST
    public RestResponse<List<SampleResponseModel>> post(SampleRequestModel request) {
        List<SampleResponseModel> data = new ArrayList<>();
        data.add(new SampleResponseModel(request.getRequestId() + "--1", request.getRequestData() + "--1"));
        data.add(new SampleResponseModel(request.getRequestId() + "--2", request.getRequestData() + "--2"));


        return ResponseBuilder
            .create(Response.Status.OK, data)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}
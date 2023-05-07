package kogito.samples.sample_rest;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

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
            .create(Status.OK, data)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}
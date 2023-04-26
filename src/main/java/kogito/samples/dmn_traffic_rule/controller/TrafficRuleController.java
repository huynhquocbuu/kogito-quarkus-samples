package kogito.samples.dmn_traffic_rule.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import kogito.samples.dmn_traffic_rule.converter.TrafficRuleConverter;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleInput;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleOutput;
import kogito.samples.dmn_traffic_rule.payload.TrafficRuleRequest;
import kogito.samples.dmn_traffic_rule.payload.TrafficRuleResponse;
import kogito.samples.dmn_traffic_rule.service.TrafficRuleService;

@Path("/traffic-rule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "age-dmn-rule", description = "Age dmn Rule")
public class TrafficRuleController {

    private TrafficRuleService ruleService;
    
    public TrafficRuleController(TrafficRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @POST
    @APIResponse(
            responseCode = "200",
            description = "Request Decision Success",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = TrafficRuleResponse.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Request Decision Fail",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = TrafficRuleResponse.class)
            )
    )
    public RestResponse<TrafficRuleResponse> ageRule(TrafficRuleRequest request) {
        
        TrafficRuleInput ruleInput = request.getRuleInput();
        TrafficRuleOutput ruleOutput = ruleService.executeRule(ruleInput);

        return TrafficRuleConverter.toRestResponseOk(ruleOutput);
    }
}

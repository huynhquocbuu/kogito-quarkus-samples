package kogito.samples.dmn_age_rule.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.resteasy.reactive.RestResponse;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.media.Content;

import kogito.samples.common.exceptionHandler.ErrorResponse;
import kogito.samples.common.httpResponseHandler.ResponseHandler;
import kogito.samples.common.httpResponseHandler.ResponseWrapper;
import kogito.samples.dmn_age_rule.rulePayload.AgeRuleInput;
import kogito.samples.dmn_age_rule.rulePayload.AgeRuleOutput;
import kogito.samples.dmn_age_rule.service.AgeRuleService;

@Path("/age-rule")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "age-dmn-rule", description = "Age dmn Rule")
public class AgeRuleController {  
    private AgeRuleService ruleService;
    public AgeRuleController(AgeRuleService ruleService) {
        this.ruleService = ruleService;
    }

    @POST
    @APIResponse(
            responseCode = "200",
            description = "Request Decision Success",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.OBJECT, implementation = ResponseWrapper<AgeRuleOutput>.class)
            )
    )
    @APIResponse(
            responseCode = "400",
            description = "Request Decision Fail",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON,
                    schema = @Schema(type = SchemaType.ARRAY, implementation = ErrorResponse.class)
            )
    )
    public RestResponse<ResponseWrapper<AgeRuleOutput>> ageRule(AgeRuleInput request) {
        AgeRuleOutput output = ruleService.executeRule(request);
        return ResponseHandler.responseOk(output);
    }
}

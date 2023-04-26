package kogito.samples.dmn_age_rule.converter;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import org.jboss.resteasy.reactive.RestResponse.Status;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;

import kogito.samples.dmn_age_rule.model.AgeRuleInput;
import kogito.samples.dmn_age_rule.model.AgeRuleOutput;
import kogito.samples.dmn_age_rule.payload.AgeRuleResponse;

public class AgeRuleConverter {
    public static DataContext toAgeRuleInput(AgeRuleInput ruleInput){
        MapDataContext dataContext = MapDataContext.create();
        
        dataContext.set("age", ruleInput.getAge());

        return dataContext;
    }
    
    public static AgeRuleOutput toAgeRuleOutput(DataContext ruleOutput){
        MapDataContext mapDataContext = ruleOutput.as(MapDataContext.class);
        
        AgeRuleOutput rt = new AgeRuleOutput();
        rt.setAge(mapDataContext.get("age", Integer.class));
        rt.setAdult(mapDataContext.get("adult", Boolean.class));

        return rt;
    }
    
    public static RestResponse<AgeRuleResponse> toRestResponseOk(AgeRuleOutput ruleOutput){
        AgeRuleResponse body = new AgeRuleResponse(
            "Success", 
            "", 
            "", 
            ruleOutput);
        
        return ResponseBuilder
            .create(Status.OK, body)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }

    public static RestResponse<AgeRuleResponse> toRestResponseErr(String errorCode, String errorMessage){
        AgeRuleResponse body = new AgeRuleResponse(
            "Error", 
            errorCode, 
            errorMessage, 
            new AgeRuleOutput());
        return ResponseBuilder
            .create(Status.BAD_REQUEST, body)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}

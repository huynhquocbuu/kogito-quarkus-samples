package kogito.samples.dmn_traffic_rule.converter;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.Response.StatusType;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.ResponseBuilder;
import org.kie.kogito.incubation.common.DataContext;
import org.kie.kogito.incubation.common.MapDataContext;

import kogito.samples.dmn_traffic_rule.model.Fine;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleInput;
import kogito.samples.dmn_traffic_rule.model.TrafficRuleOutput;
import kogito.samples.dmn_traffic_rule.payload.TrafficRuleResponse;

public class TrafficRuleConverter {

    public static DataContext toTrafficRuleInput(TrafficRuleInput ruleInput){
        MapDataContext dataContext = MapDataContext.create();

        Map<String, Object> driverMap = new HashMap<String, Object>();
        driverMap.put("Points", ruleInput.getDriver().getPoints());
        dataContext.set("Driver", driverMap);

        Map<String, Object> violationMap = new HashMap<String, Object>();
        violationMap.put("Type", ruleInput.getViolation().getType());
        violationMap.put("Actual Speed", ruleInput.getViolation().getActualSpeed());
        violationMap.put("Speed Limit", ruleInput.getViolation().getSpeedLimit());
        dataContext.set("Violation", violationMap);

        return dataContext;
    }
    
    public static TrafficRuleOutput toTrafficRuleOutput(DataContext ruleOutput){
        MapDataContext mapDataContext = ruleOutput.as(MapDataContext.class);
        
        TrafficRuleOutput rt = new TrafficRuleOutput();
        var fineMapData = mapDataContext.get("Fine", MapDataContext.class);

        Fine fine = new Fine(fineMapData.get("Amount", Number.class), fineMapData.get("Points", Number.class));
        rt.setFine(fine);
        rt.setShouldBeSuspended(mapDataContext.get("Should the driver be suspended?", String.class));

        return rt;
    }

    public static RestResponse<TrafficRuleResponse> toRestResponseOk(TrafficRuleOutput ruleOutput){
        TrafficRuleResponse body = new TrafficRuleResponse(
            "Success", 
            "", 
            "", 
            ruleOutput);
        
        return ResponseBuilder
            .create(Status.OK, body)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }

    public static RestResponse<TrafficRuleResponse> toRestResponseErr(String errorCode, String errorMessage){
        TrafficRuleResponse body = new TrafficRuleResponse(
            "Error", 
            errorCode, 
            errorMessage, 
            new TrafficRuleOutput());
        return ResponseBuilder
            .create(Status.BAD_REQUEST, body)
            .type(MediaType.APPLICATION_JSON)
            .build();
    }
}

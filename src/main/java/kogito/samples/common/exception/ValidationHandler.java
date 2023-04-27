package kogito.samples.common.exception;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class ValidationHandler implements ExceptionMapper<ConstraintViolationException>{

    @Override
    public Response toResponse(ConstraintViolationException exception) {
        ExceptionResponse body = new ExceptionResponse(
                "Error",
                "Data invalid",
                exception.getMessage()
            );
            log.error(exception.getMessage());
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity(body)
                    .build();
    }

    
    
}

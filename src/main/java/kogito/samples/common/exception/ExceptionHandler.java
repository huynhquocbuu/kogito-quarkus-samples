package kogito.samples.common.exception;

import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import lombok.extern.slf4j.Slf4j;
import jakarta.ws.rs.ext.Provider;

@Provider
@Slf4j
public class ExceptionHandler implements ExceptionMapper<Exception> {

    @Inject
    jakarta.inject.Provider<ContainerRequestContext> containerRequestContextProvider;
    
    @Override
    public Response toResponse(Exception exception) {
        Response errorResponse = mapExceptionToResponse(exception);
        return errorResponse;
    }

    private Response mapExceptionToResponse(Exception exception) {
        log.error(exception.getMessage());
        ExceptionResponse body;
        if (exception instanceof NotFoundException) {
            body = new ExceptionResponse(
                "Error",
                "Not Found",
                "---"
            );
            
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(body)
                    .build();
                
        }
        //-----------------
        body = new ExceptionResponse(
                "Error",
                "Internal Server",
                exception.getMessage()
            );
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(body)
                    .build();
    }
    
}

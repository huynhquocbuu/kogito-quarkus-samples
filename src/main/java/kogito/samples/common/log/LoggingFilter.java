package kogito.samples.common.log;

import java.io.*;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.Charsets;
import org.apache.commons.io.IOUtils;

@Provider
@Slf4j
public class LoggingFilter implements ContainerRequestFilter, ContainerResponseFilter {
    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        log.info("response = status: {}, body: {}", responseContext.getStatus(), mapper.writeValueAsString(responseContext.getEntity()));
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String json = IOUtils.toString(containerRequestContext.getEntityStream(), Charsets.UTF_8);
        log.info("request: {}", json);

        InputStream inputStream = IOUtils.toInputStream(json);
        containerRequestContext.setEntityStream(inputStream);
    }
}

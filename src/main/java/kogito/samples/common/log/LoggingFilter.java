package kogito.samples.common.log;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;


import lombok.extern.slf4j.Slf4j;

@Provider
@Slf4j
public class LoggingFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
        InputStream inputStream = requestContext.getEntityStream();
        OutputStream outputStream = responseContext.getEntityStream();
        
        
        byte[] buffer = new byte[1024];
        

        //String reBody = new String(buffer, StandardCharsets.UTF_8);

        //log.info("------response------: " + reBody);

        log.info("---response is {} -----", responseContext.getEntity());

    }


    
}

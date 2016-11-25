package tn.esprit.twin1.brogrammers.eventify.Eventify.Filters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) throws IOException {
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:8000");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
        String reqHeader = requestContext.getHeaderString("Access-Control-Request-Headers");
        if (reqHeader != null && reqHeader != "") {
            responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", reqHeader);
        }
    }
}

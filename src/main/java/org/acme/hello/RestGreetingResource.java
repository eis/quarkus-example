package org.acme.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
@Produces(MediaType.TEXT_PLAIN)
public class RestGreetingResource {

    @GET
    public String hello() {
        return "Hello from Quarkus";
    }

    @GET
    @Path("/500")
    public Response internalError() {
        return Response
                .serverError()
                .entity("Internal error from Quarkus")
                .build();
    }

    @GET
    @Path("/400")
    public Response badRequest() {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Bad request from Quarkus")
                .build();
    }
}
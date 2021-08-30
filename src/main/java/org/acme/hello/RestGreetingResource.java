package org.acme.hello;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class RestGreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus";
    }

    @GET
    @Path("/500")
    @Produces(MediaType.TEXT_PLAIN)
    public Response internalError() {
        return Response
                .serverError()
                .entity("Internal error from Quarkus")
                .build();
    }

    @GET
    @Path("/400")
    @Produces(MediaType.TEXT_PLAIN)
    public Response badRequest() {
        return Response
                .status(Response.Status.BAD_REQUEST)
                .entity("Bad request from Quarkus")
                .build();
    }
}
package org.example;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/configs")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RegisterRestClient
//@RegisterClientHeaders
@ApplicationScoped
public interface ConfigClient extends AutoCloseable {
    @GET
    @Path("/{id}")
    Config getConfig(@PathParam("id") String id);
}
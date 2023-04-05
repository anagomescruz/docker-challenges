package org.example;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/configs/check")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Slf4j
public class ConfigsCheckerResource {

    @Inject
    @RestClient
    ConfigClient configClient;

    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") final String id) {
        log.info("################# fetching for " + id);
        final Config config = configClient.getConfig(id);
        log.info("################# printing for " + config.getActive());
        final String response = config.getActive() ? "Required configuration is enabled" : "Required configuration is disabled";
        return Response.ok(response).build();
    }
}
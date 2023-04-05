package org.example;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@ApplicationScoped
@Path("/configs")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@Slf4j
public class ConfigsResource {

    @Inject
    ConfigsRepository configsRepository;

    @ConfigProperty(name = "org.example.config-creation-enabled",
                    defaultValue = "false")
    boolean configCreationEnabled;

    @POST
    public Response create(final ConfigsCreate configsCreate) {
        log.info("Creating config: {}", configsCreate.toString());
        if (configCreationEnabled) {
            final ConfigEntity configEntity =
                configsRepository.create(ConfigEntity.builder().active(configsCreate.getActive()).build());
            return Response.created(null).entity(configEntity).build();
        }
        return Response.serverError().entity("something went wrong").build();
    }


    @GET
    @Path("/{id}")
    public Response get(@PathParam("id") final String id) {
        log.info("Fetching config with ID {}", id);
        return Response.ok(configsRepository.find(id)).build();
    }
}
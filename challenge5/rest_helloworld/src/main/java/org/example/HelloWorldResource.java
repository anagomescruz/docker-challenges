package org.example;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/hello-world")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class HelloWorldResource {

    @ConfigProperty(name = "org.example.user-name",
                    defaultValue = "Failed to provide ORG_EXAMPLE_USER_NAME")
    String userName;

    @ConfigProperty(name = "org.example.second-user-name",
                    defaultValue = "Failed to provide ORG_EXAMPLE_SECOND_USER_NAME env var")
    String secondUserName;

    @GET
    @Produces(APPLICATION_JSON)
    public Response get() {
        return Response.ok("Hello World! Hello " + userName + "! Bye " + secondUserName + "!").build();
    }
}
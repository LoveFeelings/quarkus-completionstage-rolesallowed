package com.github.antoniomacri;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;


@ApplicationScoped
@Path("/")
public class SampleResource {
    @Inject
    SampleControl sampleControl;


    @GET
    @Path("protected")
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("protected-role")
    public CompletionStage<String> getProtected() {
        return sampleControl.getProtected();
    }

    @GET
    @Path("anyuser")
    @Produces(MediaType.APPLICATION_JSON)
    public CompletionStage<String> getForAnyUser() {
        return sampleControl.getForAnyUser();
    }
}

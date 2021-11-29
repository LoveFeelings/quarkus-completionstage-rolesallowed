package com.github.antoniomacri;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@RolesAllowed("protected-role")
@Path("/")
public class SampleResource {


    @POST
    @Path("protected")
    @Consumes(MediaType.APPLICATION_JSON)
    public CompletionStage<Response> getProtected(@Valid final Content data) {
        return CompletableFuture.completedFuture(Response.ok().build());
    }
}

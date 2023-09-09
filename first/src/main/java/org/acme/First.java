package org.acme;

import java.util.logging.Level;


import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.rest.client.inject.RestClient;


@Path("/sum")
public class First {

    private static final Logger LOGGER = Logger.getLogger(First.class.getName());

    @Inject
    @Claim(standard = Claims.full_name)
    String fullName;

    @Inject
    @RestClient
    Second second;

    @GET
    @Path("/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Admin")
    public int sum(@PathParam("a") int a, @PathParam("b") int b) {
        LOGGER.log(Level.INFO, "Second:{0}",fullName);
        return second.getSum(a, b);
    }
}

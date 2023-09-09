package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/hello")
public class Second {

    private static final Logger LOGGER = Logger.getLogger(Second.class.getName());

    @Inject
    @Claim(standard = Claims.email)
    String email;

    @GET
    @Path("{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed("Admin")
    public int getSum(@PathParam("a") int a, @PathParam("b") int b) {
        LOGGER.log(Level.INFO, "Second:{0}",email);
        return a + b;
    }
}

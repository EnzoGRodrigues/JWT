package org.acme;

import java.util.HashSet;
import java.util.Arrays;

import jakarta.ws.rs.POST;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.Claims;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;
import javax.annotation.security.PermitAll;
import io.smallrye.jwt.build.Jwt;

@Path("/getjwt")
public class Users {

    @POST
    @PermitAll
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String getJWT(@FormParam("username") String username, @FormParam("email") String email) {
        return Jwt.issuer("https://localhost:8443") // The issuer claim
                .upn(username) // The principal this token is issued for
                .groups(new HashSet<>(Arrays.asList("User", "Admin"))) // Groups/roles the principal is in
                .claim(Claims.full_name, username)
                .claim(Claims.email, email)
                .sign(); // Sign it with the private key
    }
}

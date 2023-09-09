package main.java.org.acme;



@RegisterRestClient()
@AcessTokes
public interface Second {

    @GET
    @Path("getSum/{a}/{b}")
    @Produces(MediaType.TEXT_PLAIN)
    @RolesAllowed({"Admin"})
    public int getSum(@PathParam("a") int a, @PathParam("b") int b);
}

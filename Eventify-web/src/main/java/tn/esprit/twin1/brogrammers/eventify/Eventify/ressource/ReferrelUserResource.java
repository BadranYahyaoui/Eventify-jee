package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RefferUserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Path("referrel")
public class ReferrelUserResource {
	
	@EJB
	RefferUserBusinessLocal refferUserBusiness;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{id}")
public Response FindReferral(@PathParam("id") int Id) {
		
		
	try {
		User r = refferUserBusiness.FindReferral(Id);
		return Response.status(Status.FOUND).entity(r).build();
	    } 
	catch (Exception e) {
		
		return Response.status(Status.NOT_ACCEPTABLE).build();
						  }
	   }

}

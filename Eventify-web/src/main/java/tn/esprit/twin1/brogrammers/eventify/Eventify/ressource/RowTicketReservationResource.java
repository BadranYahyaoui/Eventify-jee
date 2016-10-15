package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessLocal;

@Path("rowticketreservation")
@RequestScoped
public class RowTicketReservationResource {
	@EJB
	IRowTicketReservationBusinessLocal rowTicketReservationBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllRowTicketReservations()
	{

		return Response.status(Status.FOUND).entity(rowTicketReservationBusiness.getAllRowTicketReservations()).build();
		
		
	}
}

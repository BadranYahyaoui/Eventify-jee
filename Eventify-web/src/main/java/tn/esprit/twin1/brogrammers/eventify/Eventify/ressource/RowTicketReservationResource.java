package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;

@Path("rowticketreservation")
@RequestScoped
public class RowTicketReservationResource {
	@EJB
	IRowTicketReservationBusinessLocal rowTicketReservationBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<RowTicketReservation> getAllRowTicketReservations()
	{

		return rowTicketReservationBusiness.getAllRowTicketReservations();

	}
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findRowTicketReservationById(@PathParam("id") int idRowTicketReservation)
	{
		RowTicketReservation r = rowTicketReservationBusiness.findRowTicketReservationById(idRowTicketReservation);
		
		if(r==null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		else
		{
			return Response.status(Status.OK).entity(r).build();
		}
	}
	
}

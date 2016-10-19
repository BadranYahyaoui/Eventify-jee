package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;

@Path("reservation")
@RequestScoped
public class ReservationResource {
	@EJB
	IReservationBusinessLocal reservationBusiness;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllReservations()
	{

		return Response.status(Status.FOUND).entity(reservationBusiness.getAllReservations()).build();
		
		
	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findReservationById(@PathParam("id") int idReservation)
	{
		Reservation r = reservationBusiness.findReservationById(idReservation);
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

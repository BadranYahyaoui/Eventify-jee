package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

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
	
	
/*************************/

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addReservation(Reservation reservation)
	{
		reservationBusiness.create(reservation);
		return Response.status(Status.CREATED).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateReservation(Reservation reservation){
		reservationBusiness.updateReservation(reservation);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
	@Path("{id}")
	public Response deleteReservation(@PathParam(value="id")int id){
		if(reservationBusiness.deleteReservationById(id))
			{return Response.status(Status.OK).build();}
		else
		{
	return Response.status(Response.Status.NOT_FOUND).build();
		}
	}
	
	
	
	
}

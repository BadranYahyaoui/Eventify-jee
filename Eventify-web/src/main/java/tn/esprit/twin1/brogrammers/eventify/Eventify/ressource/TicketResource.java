package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

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

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

@Path("tickets")
@RequestScoped
public class TicketResource {
	@EJB
	ITicketBusinessLocal ticketBusiness;

	/*
	 * @GET
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Response getAllTickets() {
	 * 
	 * return
	 * Response.status(Status.FOUND).entity(ticketBusiness.getAllTickets()).
	 * build();
	 * 
	 * 
	 * }
	 */

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> findAllUsers() {

		return ticketBusiness.getAllTickets();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findTicketById(@PathParam("id") int id) {
		Ticket t = ticketBusiness.findTicketById(id);
		if (t == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.status(Status.OK).entity(t).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTicket(Ticket ticket) {
		ticketBusiness.create(ticket);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTicket(Ticket ticket) {
		ticketBusiness.updateTicket(ticket);
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteTicket(@PathParam(value = "id") int id) {
		if (ticketBusiness.deleteTicketById(id)) {
			return Response.status(Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}

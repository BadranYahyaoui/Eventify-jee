package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Media;

@Path("events")
@RequestScoped
public class EventResource {

	@EJB
	EventBusinessLocal eventBusiness;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Event> getAllEvents()
	{
		System.out.println("************************************");
		System.out.println(eventBusiness.getAllEvents().toString());
		System.out.println("************************************");

		return eventBusiness.getAllEvents();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findEventById(@PathParam("id") int id)
	{
		Event e = eventBusiness.findEventById(id);
		if(e==null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		else
		{
			return Response.status(Status.OK).entity(e).build();
		}
	}
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEvent(Event event)
	{
		eventBusiness.create(event);
		return Response.status(Status.CREATED).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteEvent(@PathParam(value="id")int id){
		if(eventBusiness.deleteEvent(id))
			return Response.status(204).build();
	return Response.status(Response.Status.NOT_FOUND).build();
		
	}

}

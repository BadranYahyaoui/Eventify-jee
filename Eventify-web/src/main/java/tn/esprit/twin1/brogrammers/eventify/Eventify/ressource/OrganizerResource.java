package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizerBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organizer;

@Path("organizer")
@RequestScoped
public class OrganizerResource {
	@EJB
	OrganizerBusinessLocal organizerBusiness;
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateOrganization(Organizer organizer){
		organizerBusiness.updateOrganizer(organizer);
		return Response.status(Status.OK).build();
	}
	
	@DELETE
	@Path("{id}")
	public void deleteOrganizer(@PathParam("id") int id) {

		organizerBusiness.deleteOrganizer(id);

	}
	
	
}

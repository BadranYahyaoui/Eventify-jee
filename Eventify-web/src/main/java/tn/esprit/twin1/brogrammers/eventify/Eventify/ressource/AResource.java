package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Path("a")
@RequestScoped
public class AResource {
	
	@EJB
	ABusinessLocal ab;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<A> getAllA() {

		return ab.getAllA();
	}
	
	@GET
	@Path("{id}/aa")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AA> getAAbyidA(@PathParam("id") int id){

		return ab.findAAListById(id);
	}

}

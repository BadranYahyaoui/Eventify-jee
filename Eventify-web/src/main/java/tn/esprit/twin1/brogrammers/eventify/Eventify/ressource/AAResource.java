package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;

@Path("aa")
@RequestScoped
public class AAResource {
	
	@EJB
	AABusinessLocal aab;
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<AA> getAllAA() {

		return aab.getAllAA();
	}

}

package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.Collection;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Path("wishlists")
@RequestScoped
public class WishlistResource {


	@EJB
	WishlistBusinessLocal wishlistBusiness;
	
	@EJB
	EventBusinessLocal eventBusiness;


	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addToWishlist(List list){
		System.out.println("******BEFORE*******");
		Event e = eventBusiness.findEventById((int) list.get(1));
		System.out.println(e.getTitle() + "**********" + e.getTheme());
		System.out.println("******Middle*******");
		User u = (User)list.get(0);
		System.out.println("******After CAST*******");

		wishlistBusiness.addEventToWishlist(e,u );
		System.out.println("******AFTER ADDING*******");

		return Response.status(Status.CREATED).build();
	}
	
	
	

}

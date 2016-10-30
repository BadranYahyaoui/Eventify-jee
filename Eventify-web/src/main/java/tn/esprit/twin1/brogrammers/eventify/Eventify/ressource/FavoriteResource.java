package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.FavoriteBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Favorite;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

@Path("favorites")
@RequestScoped
public class FavoriteResource {
	
	@EJB
	FavoriteBusinessLocal favoriteBusiness;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addFavorite(Favorite favorite){
		favoriteBusiness.addFavorite(favorite);
		return Response.status(Status.CREATED).build();
	}


}

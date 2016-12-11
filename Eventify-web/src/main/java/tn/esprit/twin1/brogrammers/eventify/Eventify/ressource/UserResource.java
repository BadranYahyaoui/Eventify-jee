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

import tn.esprit.twin1.brogrammers.eventify.Eventify.Filters.Secured;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;
import tn.esprit.twin1.brogrammers.eventify.Eventify.util.FaceCognitive;

/*
 *  PS : DON'T FUCKING TOUCH THIS LOVELY BY HAKIM
 */

@Path("users")
@RequestScoped
public class UserResource {

	@EJB
	UserBusinessLocal userBusiness;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user) {

		userBusiness.createUser(user);

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("confirm/{confirmationToken}")
	public Response activateAccount(@PathParam("confirmationToken") String confirmationToken) {
		boolean result = userBusiness.activateAccount(confirmationToken);
		if (result) {
			return Response.status(Status.OK).entity(true).build();
		} else {
			return Response.status(Status.FORBIDDEN).entity(false).build();
		}

	}

	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public User findUserById(@PathParam("id") int id) {

		return userBusiness.findUserById(id);
	}

	@Secured
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> findAllUsers() {

		return userBusiness.findAllUsers();
	}

	@PUT
	@Path("{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response updateUser(User user, @PathParam(value = "id") int id) {
		String imgToUpload = user.getProfileImage();
		if (imgToUpload != null) {
			if (userBusiness.uploadProfileImage(imgToUpload)) {
				if (user.getId() == 0) {
					user.setId(id);
				}
				userBusiness.updateUser(user);
				return Response.status(Status.OK).entity(true).build();
			} else {
				if (user.getId() == 0) {
					user.setId(id);
				}
				userBusiness.updateUser(user);
				return Response.status(Status.FORBIDDEN).entity(false).build();
			}
		}

		userBusiness.updateUser(user);
		return Response.status(Status.OK).entity("Problem not image changed").build();

	}

	@DELETE
	@Path("{id}")
	public void deleteUser(@PathParam("id") int id) {

		userBusiness.deleteUser(id);

	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{username}/{pwd}")
	public String loginUser(@PathParam("username") String username, @PathParam("pwd") String pwd) {
		return userBusiness.loginUser(username, pwd);
	}
	
	@Secured
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{oldPwd}/{newPwd}")
	public Response changePwd(User user,@PathParam("oldPwd") String oldPwd, @PathParam("newPwd") String newPwd) {
		if(userBusiness.changePwd(user,oldPwd, newPwd))
		return Response.status(Status.OK).entity(true).build();
		else
		{
			return Response.status(Status.FORBIDDEN).entity(false).build();
		}
	}


	// added by Ibra
	@GET
	@Produces
	@Path("{id}/wishlist")
	public List<Wishlist> getMyWishlist(@PathParam("id") int id) {
		return userBusiness.getMyWishlist(id);
	}

}

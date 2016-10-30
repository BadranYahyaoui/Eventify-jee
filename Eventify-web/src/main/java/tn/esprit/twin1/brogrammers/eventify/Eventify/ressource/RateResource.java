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

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessLocal;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;

@Path("rates")
@RequestScoped
public class RateResource {
	
	@EJB
	RateBusinessLocal RateBusiness;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addRate(Rate rate)
	{
		
		try {
			RateBusiness.createRate(rate);
			return Response.status(Status.CREATED).build();
		    } 
		catch (Exception e)
		{
			return Response.status(Status.NOT_ACCEPTABLE).build();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateRate(Rate rate){
		try {
			RateBusiness.modifyRate(rate);
			return Response.status(Status.OK).build();
		} catch (Exception e) {
			return Response.status(Status.NOT_MODIFIED).build();
		}

	}
	
	
	@DELETE
	@Path("{id}")
	public Response deleteAnswer(@PathParam(value="id")int id){
		
		boolean b = RateBusiness.deleteRate(id);
		if(b)
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_FOUND).build();

	}
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response getRateByUserId(@PathParam("id")int id) 
	{
		List rates = (List) RateBusiness.getRateByUserId(id);
		if(rates.size()!=0)
			return Response.status(Status.OK).entity(rates).build();
		else
			return Response.status(Status.NOT_FOUND).build();

	}

	
	

}

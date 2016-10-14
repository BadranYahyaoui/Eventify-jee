package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.websocket.server.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Questions;

@Path("questions")
@RequestScoped
public class QuestionsResource {
	
	@EJB
	QuestionBusinessLocal questionBusiness;
	
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addQuestion(Questions questions){
		questionBusiness.createQuestion(questions);
		return Response.status(Status.CREATED).build();
		
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateQuestion(Questions questions){
		if(questionBusiness.updateQuestion(questions))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_MODIFIED).build();
		
	}

	@DELETE
	@Path("id")
	public Response deleteQuestion(@PathParam(value="id")int id){
		if(questionBusiness.deleteQuestion(id))
			return Response.status(Status.OK).build();
		else
			return Response.status(Status.NOT_FOUND).build();
		
	}

	@GET
	@Path("id")
	public Response getQuestionById(@PathParam(value="id")int id){
		if(questionBusiness.getQuestionById(id)!=null)
			
			return Response.status(Status.OK).entity(questionBusiness.getQuestionById(id)).build();
		else
			return Response.status(Status.NOT_FOUND).build();
		
	}

	
}

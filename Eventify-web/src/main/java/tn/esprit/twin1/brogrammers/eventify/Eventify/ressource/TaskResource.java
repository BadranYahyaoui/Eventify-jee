package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

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

import tn.esprit.twin1.brogrammers.eventify.Eventify.business.TaskBusiness;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Task;

@Path("Tasks")
@RequestScoped
public class TaskResource {
	@EJB
	TaskBusiness taskBusniss;
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEvent(Task task){
		
		taskBusniss.updateTask(task);
		return Response.status(Status.OK).build();
	}
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public Response deleteTask(Task task){
		taskBusniss.deleteTask(task);
		return Response.status(Status.OK).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findTAskById(@PathParam("id") int id)
	{
		Task t=taskBusniss.findTaskByID(id);
		if(t==null)
		{
			return Response.status(Status.NOT_FOUND).build();
		}
		
			return Response.status(Status.OK).entity(t).build();
		
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("TasksByEvent/{id}")
	public Response getAllTasksByEventID(@PathParam("id") int id){
		if(taskBusniss.getAllTasksByID(id)==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(taskBusniss.getAllTasksByID(id)).build();
	}
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("TasksByOganizert/{id}")
	public Response getAllTasksByOganizerID(@PathParam("id") int id){
		if(taskBusniss.GetTasksByOrganizer(id)==null){
			return Response.status(Status.NOT_FOUND).build();
		}
		return Response.status(Status.OK).entity(taskBusniss.GetTasksByOrganizer(id)).build();
	}
	
	@GET

	@Path("cancelTask/{id1}/{id2}")
	public Response cancelTask(@PathParam("id1")int taskId,@PathParam("id2") int idOrganizer){
		taskBusniss.cancelTask(taskId, idOrganizer);
		
		return Response.status(Status.OK).build();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("taskStatusCompleted/{id1}/{id2}")
	public Response SetTaskStatusCompleted(@PathParam("id1")int idOrgnizer,@PathParam("id2") int Taskid){
		taskBusniss.taskStatusCompleted(idOrgnizer, Taskid);
		return Response.status(Status.OK).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createATask(Task task)
	{
		taskBusniss.createTask(task);
		return Response.status(Status.CREATED).build();
	}
	
	
	
	
	
	
	
}

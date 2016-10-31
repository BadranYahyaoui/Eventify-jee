package tn.esprit.twin1.brogrammers.eventify.Eventify.ressource;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.twin1.brogrammers.eventify.Eventify.util.CognitiveServiceTextAnalytics;
@Path("sentiments")
@RequestScoped
public class SentimentResource {


	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getScore(){
		String t = CognitiveServiceTextAnalytics.GetSentimentAnalytics();
		return t;

	}

}

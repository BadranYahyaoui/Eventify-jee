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

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;

@Path("transaction")
@RequestScoped
public class TransactionResource {

	@EJB
	ITransactionBusinessLocal transactionBusiness;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Transaction> getAllTransaction() {

		return transactionBusiness.getAllTransactions();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public Response findTransactionById(@PathParam("id") int id) {
		Transaction t = transactionBusiness.findTransactionById(id);
		if (t == null) {
			return Response.status(Status.NOT_FOUND).build();
		} else {
			return Response.status(Status.OK).entity(t).build();
		}
	}

	/********/

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addTransaction(Transaction transaction) {
		transactionBusiness.create(transaction);
		return Response.status(Status.CREATED).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateTransaction(Transaction transaction) {
		transactionBusiness.updateTransaction(transaction);
		return Response.status(Status.OK).build();
	}

	@DELETE
	@Path("{id}")
	public Response deleteTransaction(@PathParam(value = "id") int id) {
		if (transactionBusiness.deleteTransactionById(id)) {
			return Response.status(Status.OK).build();
		} else {
			return Response.status(Response.Status.NOT_FOUND).build();
		}
	}

}

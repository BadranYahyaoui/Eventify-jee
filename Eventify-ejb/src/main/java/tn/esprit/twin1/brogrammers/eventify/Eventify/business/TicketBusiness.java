package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class TicketBusiness
 */
@Stateless
public class TicketBusiness implements ITicketBusinessRemote, ITicketBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

	@EJB
	EventBusinessLocal eventbusiness;

	@Override
	public void create(Ticket ticket) {

		try {
			entityManager.persist(ticket);
		} catch (Exception e) {
			System.err.println("Can't add Ticket! :(");
		}
	}

	@Override
	public List<Ticket> getAllTickets() {
		List<Ticket> ticket = (List<Ticket>) entityManager
				.createQuery("SELECT new Ticket(t.id,t.nbTickets,t.typeTicket,t.priceTicket,t.backgroundImage,event) "
						+ "FROM Ticket t JOIN t.event event")
				.getResultList();

		for (Ticket tickets : ticket) {

			Event event = eventbusiness.findEventById(tickets.getEvent().getId());
			tickets.setEvent(null); /*
									 * A VERIFIER POUR GETALLEVENT WITHOUT
									 * BLOCKING THE REST OF DISPLAY
									 */

		}
		return ticket;
	}

	@Override
	public void updateTicket(Ticket ticket) {
		try {
			entityManager.merge(ticket);

		} catch (Exception e) {
			System.err.println("Can't modify Ticket! :(");
		}
	}

	@Override
	public boolean deleteTicketById(int id) {
		entityManager.remove(entityManager.find(Ticket.class, id));
		return true;
	}

	@Override
	public Ticket findTicketById(int idTicket) {
		Query query = entityManager
				.createQuery("SELECT new Ticket(t.id,t.nbTickets,t.typeTicket,t.priceTicket,t.backgroundImage) "
						+ "FROM Ticket t WHERE t.id=:idtick");

		Ticket t = (Ticket) query.setParameter("idtick", idTicket).getSingleResult();
		// t.setEvent(eventbusiness.findEventById(t.getEvent().getId()));
		return t;
	}

	@Override
	public List<Ticket> findTicketByType(String typeTicket) {
		Query query = entityManager.createQuery("SELECT NEW Ticket(t.id,t.nbTickets, t.priceTicket, t.typeTicket) FROM Ticket t WHERE t.typeTicket LIKE :typeTicket")
				.setParameter("typeTicket", typeTicket);
		return (List<Ticket>) query.getResultList();
	}



	/**************************************** MET ********************************/
	@Override
	public List<Ticket> getAllTicketsEventGroupedByType(int idevent) {
		Query query  = entityManager.createQuery("SELECT NEW Ticket(t.id,t.nbTickets, t.priceTicket, t.typeTicket) FROM Ticket t where event.id =:idevent GROUP BY t.typeTicket,t.id")
				.setParameter("idevent", idevent);
		return (List<Ticket>) query.getResultList();
	}

	@Override
	public List<Ticket> AvailableTicketsOrderByPrice(int idevent) {
		Query query  = entityManager.createQuery("SELECT NEW Ticket(t.id,t.nbTickets, t.priceTicket, t.typeTicket) FROM Ticket t where event.id =:idevent "
				+ "AND t.nbTickets > 0 ORDER BY t.priceTicket ASC")
				.setParameter("idevent", idevent);
		return (List<Ticket>) query.getResultList();
	}

	@Override
	public boolean UpdateNbTicket(int idTicket,int nbareser) {
		Query query  = entityManager.createQuery("UPDATE Ticket SET nbTickets =:nbareser where id =:idTicket")
				.setParameter("idTicket", idTicket)
				.setParameter("nbareser", nbareser);
		query.executeUpdate();
		return true;
	}
}

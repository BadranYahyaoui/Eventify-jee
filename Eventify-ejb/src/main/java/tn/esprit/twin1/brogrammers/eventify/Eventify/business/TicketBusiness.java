package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

/**
 * Session Bean implementation class TicketBusiness
 */
@Stateless
@LocalBean
public class TicketBusiness implements ITicketBusinessRemote, ITicketBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	
    public TicketBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void create(Ticket ticket) {
		entityManager.persist(ticket);
		
	}

	
	@Override
	public List<Ticket> getAllTickets() {
		 Query query = entityManager.createQuery("SELECT t FROM Ticket t");
		    return (List<Ticket>) query.getResultList();
	}

	@Override
	public void updateTicket(Ticket ticket) {
		entityManager.merge(ticket);	
		
	}

	@Override
	public boolean deleteTicket(Ticket ticket) {
		entityManager.remove(entityManager.merge(ticket));
		return true;
	}

	@Override
	public boolean deleteTicketById(int id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public Ticket findTicketById(int idTicket) {
		return entityManager.find(Ticket.class, idTicket);
	}

	@Override
	public List<Ticket> findTicketByType(String typeTicket) {
		Query query = entityManager
	    		.createQuery("SELECT t FROM Ticket t WHERE t.typeTicket LIKE :typeTicket")
	    		.setParameter("type", typeTicket);
	    return (List<Ticket>) query.getResultList();
	}





}

package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

/**
 * Session Bean implementation class RowTicketReservationBusiness
 */
@Stateless
@LocalBean
public class RowTicketReservationBusiness implements IRowTicketReservationBusinessRemote, IRowTicketReservationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	

	@Override
	public void create(RowTicketReservation rowTicketReservation) {
		entityManager.persist(rowTicketReservation);
		
	}

	@Override
	public List<RowTicketReservation> getAllRowTicketReservations() {
		Query query = entityManager.createQuery("SELECT r FROM RowTicketReservation r");
	    return (List<RowTicketReservation>) query.getResultList();
	}

	@Override
	public void updateTicket(RowTicketReservation rowTicketReservation) {
		entityManager.merge(rowTicketReservation);	
		
	}

	@Override
	public boolean deleteRowTicketReservation(RowTicketReservation rowTicketReservation) {
		entityManager.remove(entityManager.merge(rowTicketReservation));
		return true;
	}

	@Override
	public boolean deleteRowTicketReservationById(int idRowTicketReservation) {
		Iterator<RowTicketReservation> iterator=this.getAllRowTicketReservations().iterator();
		while(iterator.hasNext()){
			RowTicketReservation r=iterator.next();
			if(r.getId()==idRowTicketReservation){
				entityManager.remove(this.findRowTicketReservationById(idRowTicketReservation));
				return true;
			}
		}
		return false;
		

	}
	
	@Override
	public RowTicketReservation findRowTicketReservationById(int idRowTicketReservation) {
		return entityManager.find(RowTicketReservation.class, idRowTicketReservation);
	}

	@Override
	public List<RowTicketReservation> findRowTicketReservationByIdTicket(int idFKTicket) {
		Query query = entityManager.createQuery("SELECT r FROM RowTicketReservation r where r.ticket_id = idFKTicket");
	    return (List<RowTicketReservation>) query.getResultList();
	}

	@Override
	public List<RowTicketReservation> findRowTicketReservationByIdReservation(int idFKReservation) {
		Query query = entityManager.createQuery("SELECT r FROM RowTicketReservation r where r.reservation_id = idFKReservation");
	    return (List<RowTicketReservation>) query.getResultList();
	}

}

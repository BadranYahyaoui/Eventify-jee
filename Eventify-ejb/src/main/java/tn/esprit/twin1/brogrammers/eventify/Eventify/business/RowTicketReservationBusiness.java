package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class RowTicketReservationBusiness
 */
@Stateless
@LocalBean
public class RowTicketReservationBusiness implements IRowTicketReservationBusinessRemote, IRowTicketReservationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	@EJB
	IReservationBusinessLocal reservationbusinessloccal;
	@EJB
	ITicketBusinessLocal ticketbusinessloccal;
	

	@Override
	public void create(RowTicketReservation rowTicketReservation) {
		entityManager.persist(rowTicketReservation);
		
	}
	
	@Override
	public List<RowTicketReservation> getAllRowTicketReservations() {

		List<RowTicketReservation> rowticketreservation= (List<RowTicketReservation>) entityManager.createQuery("SELECT "
		+ "new RowTicketReservation(rowticketreservation.id,rowticketreservation.nbTicketsReserved,rowticketreservation.reservationDate,reservation,ticket)  FROM RowTicketReservation rowticketreservation JOIN rowticketreservation.ticket ticket JOIN rowticketreservation.reservation reservation").getResultList();
	
		
		
		for (RowTicketReservation forrow : rowticketreservation) {
			Ticket ticket = ticketbusinessloccal.findTicketById(forrow.getTicket().getId());
			forrow.setTicket(ticket);
			
			Reservation reservation = reservationbusinessloccal.findReservationById(forrow.getReservation().getId());
		forrow.setReservation(reservation);

		
			
		}
		
		
		return rowticketreservation;
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
		Query query = entityManager.createQuery("SELECT new RowTicketReservation(r.id, r.nbTicketsReserved, r.reservationDate) FROM RowTicketReservation r WHERE r.id=:idrow");
		//RowTicketReservation r = (RowTicketReservation) query.setParameter("idrow", idRowTicketReservation).getSingleResult();
		//r.setTicket(ticketbusinessloccal.findTicketById(r.getTicket().getId()));
		//r.setReservation(reservationbusinessloccal.findReservationById(r.getReservation().getId()));
		return (RowTicketReservation) query.setParameter("idrow", idRowTicketReservation).getSingleResult();
	}

	@Override
	public List<RowTicketReservation> findRowTicketReservationByIdTicket(int idFKTicket) {
		Query query = entityManager.createQuery("SELECT r FROM RowTicketReservation r where r.ticket_id = idFKTicket");
	    return (List<RowTicketReservation>) query.getSingleResult();
	}

	@Override
	public List<RowTicketReservation> findRowTicketReservationByIdReservation(int idFKReservation) {
		Query query = entityManager.createQuery("SELECT r FROM RowTicketReservation r where r.reservation_id = idFKReservation");
	    return (List<RowTicketReservation>) query.getSingleResult();
	}

}

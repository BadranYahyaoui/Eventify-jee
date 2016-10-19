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
	private int id;
	private int nbTicketsReserved;
	private Date reservationDate;
	private Reservation reservation;
	private Ticket ticket;
	@Override
	public List<RowTicketReservation> getAllRowTicketReservations() {
		/*
List<RowTicketReservation> rowticketreservation= (List<RowTicketReservation>) entityManager.createQuery("SELECT "
		+ "new RowTicketReservation(rowticketreservation.id,rowticketreservation.nbTicketsReserved,rowticketreservation.reservationDate,reservation,ticket)  FROM RowTicketReservation rowticketreservation  JOIN  rowticketreservation.reservation reservation LEFT JOIN  rowticketreservation.ticket ticket").getResultList();
		*/
		
		List<RowTicketReservation> rowticketreservation= (List<RowTicketReservation>) entityManager.createQuery("SELECT "
		+ "new RowTicketReservation(rowticketreservation.id,rowticketreservation.nbTicketsReserved,rowticketreservation.reservationDate,reservation, ticket)  FROM RowTicketReservation rowticketreservation  JOIN rowticketreservation.ticket ticket LEFT JOIN rowticketreservation.reservation reservation   ").getResultList();
				
		
		
		for (RowTicketReservation forrow : rowticketreservation) {
			
			Reservation reservation = this.entityManager.find(Reservation.class, 1);
			forrow.setReservation(reservation);
			
			Ticket ticket = this.entityManager.find(Ticket.class, 1);
			forrow.setTicket(ticket);
			
			//Reservation reservation=reservationbusinessloccal.findReservationById(forrow.getReservation().getId());
		//	forrow.setReservation(reservation);
			//System.out.println(reservation);
		//	System.out.println("lool");
		//	Ticket ticket=ticketbusinessloccal.findTicketById(forrow.getTicket().getId());
		//	System.out.println(ticket);
		//	forrow.setTicket(ticket);
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

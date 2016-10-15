package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

/**
 * Session Bean implementation class ReservationBusiness
 */
@Stateless
@LocalBean
public class ReservationBusiness implements IReservationBusinessRemote, IReservationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	@Override
	public void create(Reservation reservation) {
		entityManager.persist(reservation);
		
	}

	@Override
	public List<Reservation> getAllReservations() {
		Query query = entityManager.createQuery("SELECT r FROM Reservation r");
	    return (List<Reservation>) query.getResultList();
	}
	@Override
	public void updateReservation(Reservation reservation) {
		entityManager.merge(reservation);	
		
	}

	@Override
	public boolean deleteReservation(Reservation reservation) {
		entityManager.remove(entityManager.merge(reservation));
		return true;
	}

	@Override
	public boolean deleteReservationById(int id) {
		Iterator<Reservation> iterator=this.getAllReservations().iterator();
		while(iterator.hasNext()){
			Reservation r=iterator.next();
			if(r.getId()==id){
				entityManager.remove(this.findReservationById(id));
				return true;
			}
		}
		return false;
	}

	@Override
	public Reservation findReservationById(int idReservation) {
		return entityManager.find(Reservation.class, idReservation);
	}

	@Override
	public List<Reservation> findReservationByState(int state) {
		Query query = entityManager
	    		.createQuery("SELECT r FROM Reservation r WHERE r.state = state")
	    		.setParameter("state", state);
	    return (List<Reservation>) query.getResultList();
	}

}

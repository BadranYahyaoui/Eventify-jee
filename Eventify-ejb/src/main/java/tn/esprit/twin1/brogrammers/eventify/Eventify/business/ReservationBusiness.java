package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class ReservationBusiness
 */
@Stateless
@LocalBean
public class ReservationBusiness implements IReservationBusinessRemote, IReservationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	@EJB
	UserBusinessLocal userbusiness;
	
	@EJB
	ITransactionBusinessLocal transactionbusiness;
	@Override
	public void create(Reservation reservation) {
		entityManager.persist(reservation);
		
	}

	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservation= (List<Reservation>)  entityManager.createQuery("SELECT new Reservation(r.id,r.amount,r.reservationDate,r.state, user, transaction) "
						+ "FROM Reservation r JOIN r.user user JOIN r.transaction transaction  ").getResultList();
		
		for (Reservation reservations : reservation) {
			User user = userbusiness.findUserById(reservations.getUser().getId());
			reservations.setUser(user);
			
			//Transaction transaction = transactionbusiness.findTransactionById(reservations.getTransaction().getId());
			//reservations.setTransaction(transaction);
			
		}    return reservation;
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
		Query query = entityManager.createQuery("SELECT new Reservation(r.id,r.amount,r.reservationDate,r.state) "
				+ "FROM Reservation r WHERE r.id=:idres");
		
		Reservation r = (Reservation) query.setParameter("idres", idReservation).getSingleResult();
		//r.setUser(userbusiness.findUserById(r.getUser().getId()));
		return r;
	}

	@Override
	public List<Reservation> findReservationByState(int state) {
		Query query = entityManager
	    		.createQuery("SELECT r FROM Reservation r WHERE r.state = state")
	    		.setParameter("state", state);
	    return (List<Reservation>) query.getResultList();
	}

}

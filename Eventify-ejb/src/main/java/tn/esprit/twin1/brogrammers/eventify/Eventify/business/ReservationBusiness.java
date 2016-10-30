package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;
import java.util.Timer;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.TimerState;

/**
 * Session Bean implementation class ReservationBusiness
 */
@Stateless
public class ReservationBusiness implements IReservationBusinessRemote, IReservationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	@EJB
	UserBusinessLocal userbusiness;

	@EJB
	ITransactionBusinessLocal transactionbusiness;
	@EJB
	ITicketBusinessLocal ticketbusiness;

	@Override
	public void create(Reservation reservation) {
		entityManager.persist(reservation);
		System.out.print(reservation);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Reservation> getAllReservations() {
		List<Reservation> reservation = (List<Reservation>) entityManager.createQuery(
				"SELECT new Reservation(r.id,r.amount,r.reservationDate,r.reservationState,r.paymentMethod , user,ticket,r.timerState) "
						+ "FROM Reservation r JOIN r.user user JOIN r.ticket ticket  ")
				.getResultList();

		for (Reservation reservations : reservation) {
			User user = userbusiness.findUserById(reservations.getUser().getId());
			reservations.setUser(user);

			Ticket ticket = ticketbusiness.findTicketById(reservations.getTicket().getId());
			reservations.setTicket(ticket);

			// Transaction transaction =
			// transactionbusiness.findTransactionById(reservations.getTransaction().getId());
			// reservations.setTransaction(transaction);

		}
		return reservation;
	}

	@Override
	public void updateReservation(Reservation reservation) {

		entityManager.merge(reservation);

	}

	@Override
	public boolean deleteReservationById(int id) {
		entityManager.remove(entityManager.find(Reservation.class, id));
		return true;
	}

	@Override
	public Reservation findReservationById(int idReservation) {
		Query query = entityManager.createQuery(
				"SELECT new Reservation(r.id,r.amount,r.reservationDate,r.reservationState,r.paymentMethod) "
						+ "FROM Reservation r WHERE r.id=:idres");

		Reservation r = (Reservation) query.setParameter("idres", idReservation).getSingleResult();
		// r.setUser(userbusiness.findUserById(r.getUser().getId()));
		return r;
	}

	@Override
	public List<Reservation> findReservationByState(int state) {
		Query query = entityManager.createQuery("SELECT r FROM Reservation r WHERE r.state = state")
				.setParameter("state", state);
		return (List<Reservation>) query.getResultList();
	}

	/* MET */

	/* MET */
}

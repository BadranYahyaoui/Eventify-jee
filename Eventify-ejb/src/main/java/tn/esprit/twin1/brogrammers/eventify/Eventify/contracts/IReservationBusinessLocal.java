package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;

@Local
public interface IReservationBusinessLocal {
	
	public void create(Reservation reservation);
	public List<Reservation> getAllReservations();
	public void updateReservation(Reservation reservation);
	public boolean deleteReservationById(int id);
	public Reservation findReservationById(int idReservation);
	public List<Reservation> findReservationByState(int state);
	
	/*MET*/
	/*MET*/
}

package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;

@Remote
public interface IReservationBusinessRemote {
	public void create(Reservation reservation);
	public List<Reservation> getAllReservations();
	public void updateReservation(Reservation reservation);
	public boolean deleteReservation(Reservation reservation);
	public boolean deleteReservationById(int id);
	public Reservation findReservationById(int idReservation);
	public List<Reservation> findReservationByState(int state);
}

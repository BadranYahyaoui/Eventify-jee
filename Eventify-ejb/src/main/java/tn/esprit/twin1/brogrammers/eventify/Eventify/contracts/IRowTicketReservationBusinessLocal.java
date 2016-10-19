package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;

@Local
public interface IRowTicketReservationBusinessLocal {
	
	public void create(RowTicketReservation rowTicketReservation);
	public List<RowTicketReservation> getAllRowTicketReservations();
	public void updateTicket(RowTicketReservation rowTicketReservation);
	public boolean deleteRowTicketReservation(RowTicketReservation rowTicketReservation);
	public boolean deleteRowTicketReservationById(int idRowTicketReservation);
	public List<RowTicketReservation> findRowTicketReservationByIdTicket(int idFKTicket);
	public List<RowTicketReservation> findRowTicketReservationByIdReservation(int idFKReservation);
	public RowTicketReservation findRowTicketReservationById(int idRowTicketReservation);

	
}

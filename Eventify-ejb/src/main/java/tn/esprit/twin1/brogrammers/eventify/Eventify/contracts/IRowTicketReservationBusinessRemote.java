package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;

@Remote
public interface IRowTicketReservationBusinessRemote {
	
	public void create(RowTicketReservation rowTicketReservation);
	public List<RowTicketReservation> getAllRowTicketReservations();
	public void updateTicket(RowTicketReservation rowTicketReservation);
	public boolean deleteRowTicketReservationById(int idRowTicketReservation);
	public RowTicketReservation findRowTicketReservationById(int idRowTicketReservation);
	public List<RowTicketReservation> findRowTicketReservationByIdTicket(int idFKTicket);
	public List<RowTicketReservation> findRowTicketReservationByIdReservation(int idFKReservation);
	public boolean deleteRowTicketReservation(RowTicketReservation rowTicketReservation);
}

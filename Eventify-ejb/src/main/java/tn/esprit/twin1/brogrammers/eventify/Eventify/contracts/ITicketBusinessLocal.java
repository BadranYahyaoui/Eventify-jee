package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

@Local
public interface ITicketBusinessLocal {

	public void create(Ticket ticket);
	public List<Ticket> getAllTickets();
	public void updateTicket(Ticket ticket);
	public boolean deleteTicket(Ticket ticket);
	public boolean deleteTicketById(int id);
	public Ticket findTicketById(int idTicket);
	public List<Ticket> findTicketByType(String typeTicket);
	
	
	
}

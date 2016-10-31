package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

@Remote
public interface ITicketBusinessRemote {

	public void create(Ticket ticket);

	public List<Ticket> getAllTickets();

	public void updateTicket(Ticket ticket);

	public boolean deleteTicketById(int id);

	public Ticket findTicketById(int idTicket);

	public List<Ticket> findTicketByType(String typeTicket);
	

	/** MET **/
	public List<Ticket> getAllTicketsEventGroupedByType(int idevent);
	public List<Ticket> AvailableTicketsOrderByPrice(int idevent);
	public boolean UpdateNbTicket(int idTicket,int nbareser);
	public String TicketsPerCent(int eventId);

	/** MET **/

}

package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Ticket
 *
 */
@Entity

public class Ticket implements Serializable {

	   
	
	private int id;
	private int nbTickets;
	private String typeTicket;
	private float priceTicket;
	private String paymentMethod;
	private String backgroundImage;
	private List<RowTicketReservation> rowticketreservations;
	private static final long serialVersionUID = 1L;

	private Event event;
	
	public Ticket() {
		super();
	}   
	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getNbTickets() {
		return this.nbTickets;
	}

	public void setNbTickets(int nbTickets) {
		this.nbTickets = nbTickets;
	}   
	public String getTypeTicket() {
		return this.typeTicket;
	}

	public void setTypeTicket(String typeTicket) {
		this.typeTicket = typeTicket;
	}   
	public float getPriceTicket() {
		return this.priceTicket;
	}

	public void setPriceTicket(float priceTicket) {
		this.priceTicket = priceTicket;
	}   
	public String getPaymentMethod() {
		return this.paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}   
	public String getBackgroundImage() {
		return this.backgroundImage;
	}

	public void setBackgroundImage(String backgroundImage) {
		this.backgroundImage = backgroundImage;
	}
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ticket", fetch = FetchType.LAZY)
	public List<RowTicketReservation> getRowticketreservations() {
		return rowticketreservations;
	}
	public void setRowticketreservations(List<RowTicketReservation> rowticketreservations) {
		this.rowticketreservations = rowticketreservations;
	}
	
	@ManyToOne
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
   
	
	
}

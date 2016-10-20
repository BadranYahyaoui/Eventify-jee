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
	private List<Reservation> reservations;
	private static final long serialVersionUID = 1L;

	private Event event;
	
	public Ticket(int id, int nbTickets, String typeTicket, float priceTicket, String paymentMethod,
			String backgroundImage) {
		super();
		this.id = id;
		this.nbTickets = nbTickets;
		this.typeTicket = typeTicket;
		this.priceTicket = priceTicket;
		this.paymentMethod = paymentMethod;
		this.backgroundImage = backgroundImage;
	}
	
	public Ticket(int id, int nbTickets, String typeTicket, float priceTicket, String paymentMethod,
			String backgroundImage, Event event) {
		super();
		this.id = id;
		this.nbTickets = nbTickets;
		this.typeTicket = typeTicket;
		this.priceTicket = priceTicket;
		this.paymentMethod = paymentMethod;
		this.backgroundImage = backgroundImage;
		this.event = event;
	}
	
	
	
	public Ticket() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@ManyToOne
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}
	@Override
	public String toString() {
		return "Ticket [id=" + id + ", nbTickets=" + nbTickets + ", typeTicket=" + typeTicket + ", priceTicket="
				+ priceTicket + ", paymentMethod=" + paymentMethod + ", backgroundImage=" + backgroundImage
				+  ", event=" + event + "]";
	}
   
	
	
}

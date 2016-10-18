package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: RowTicketReservation
 *
 */
@Entity

public class RowTicketReservation implements Serializable {

	   
	
	private int id;
	private int nbTicketsReserved;
	private Date reservationDate;
	private Reservation reservation;
	private Ticket ticket;
	private static final long serialVersionUID = 1L;

	public RowTicketReservation() {
		super();
	}   
	public RowTicketReservation(int id, int nbTicketsReserved, Date reservationDate, Reservation reservation,
		Ticket ticket) {
		super();
		this.id = id;
		this.nbTicketsReserved = nbTicketsReserved;
		this.reservationDate = reservationDate;
		this.reservation = reservation;
		this.ticket = ticket;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public int getNbTicketsReserved() {
		return this.nbTicketsReserved;
	}

	public void setNbTicketsReserved(int nbTicketsReserved) {
		this.nbTicketsReserved = nbTicketsReserved;
	}
	public Date getReservationDate() {
		return reservationDate;
	}
	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	@Override
	public String toString() {
		return "RowTicketReservation [id=" + id + ", nbTicketsReserved=" + nbTicketsReserved + ", reservationDate="
				+ reservationDate + ", reservation=" + reservation + ", ticket=" + ticket + "]";
	}   

   
}

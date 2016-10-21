package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventState;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.PaymentMethod;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.ReservationState;


/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

public class Reservation implements Serializable {

	   
	
	private int id;
	private float amount;
	private Date reservationDate;
	private User user;
	private ReservationState reservationState;
	private PaymentMethod paymentMethod;
	private Transaction transaction;
	private Ticket ticket;
	private static final long serialVersionUID = 1L;

	public Reservation(int id, float amount, Date reservationDate,  ReservationState reservationState,PaymentMethod paymentMethod ,User user, Transaction transaction,
			Ticket ticket) {
		super();
		this.id = id;
		this.amount = amount;
		this.reservationDate = reservationDate;
		this.user = user;
		this.reservationState = reservationState;
		this.paymentMethod=paymentMethod;
		this.transaction = transaction;
		this.ticket = ticket;
	}
	public Reservation(int id, float amount, Date reservationDate, ReservationState reservationState, User user, Transaction transaction) {
		super();
		this.id = id;
		this.amount = amount;
		this.reservationDate = reservationDate;
		this.user = user;
		this.reservationState = reservationState;
		this.transaction = transaction;
	}
	public Reservation(int id, float amount, Date reservationDate, ReservationState reservationState,PaymentMethod paymentMethod) {
		super();
		this.id = id;
		this.amount = amount;
		this.reservationDate = reservationDate;
		this.reservationState = reservationState;
		this.paymentMethod=paymentMethod;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Enumerated(EnumType.STRING)
	public ReservationState getReservationState() {
		return reservationState;
	}
	public void setReservationState(ReservationState reservationState) {
		this.reservationState = reservationState;
	}
	public Reservation() {
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
	
	public float getAmount() {
		return this.amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}   
	
	
	public Date getReservationDate() {
		return this.reservationDate;
	}

	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}
	@OneToOne(mappedBy="reservation")
	public Transaction getTransaction() {
		return transaction;
	}
	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}
	
	@ManyToOne(fetch = FetchType.LAZY)
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	@Enumerated(EnumType.STRING)
	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", amount=" + amount + ", reservationDate=" + reservationDate + ", user="
				+ user + ", ReservationState reservationState=" + reservationState + ", transaction=" + transaction + ",+ ]";
	}
   
}

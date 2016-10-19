package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;


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
	private int state;
	private Transaction transaction;
	private List<RowTicketReservation> rowticketreservations;
	private static final long serialVersionUID = 1L;

	
	public Reservation(int id, float amount, Date reservationDate, int state, User user, Transaction transaction) {
		super();
		this.id = id;
		this.amount = amount;
		this.reservationDate = reservationDate;
		this.user = user;
		this.state = state;
		this.transaction = transaction;
	}
	public Reservation(int id, float amount, Date reservationDate, int state) {
		super();
		this.id = id;
		this.amount = amount;
		this.reservationDate = reservationDate;
		this.state = state;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
	
	@OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY)
	public List<RowTicketReservation> getRowticketreservations() {
		return rowticketreservations;
	}
	public void setRowticketreservations(List<RowTicketReservation> rowticketreservations) {
		this.rowticketreservations = rowticketreservations;
	}
	@Override
	public String toString() {
		return "Reservation [id=" + id + ", amount=" + amount + ", reservationDate=" + reservationDate + ", user="
				+ user + ", state=" + state + ", transaction=" + transaction + ", rowticketreservations="
				+ rowticketreservations + "]";
	}
   
}

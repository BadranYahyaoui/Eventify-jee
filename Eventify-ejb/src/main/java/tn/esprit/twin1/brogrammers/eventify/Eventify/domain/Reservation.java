package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reservation
 *
 */
@Entity

public class Reservation implements Serializable {

	   
	
	private int id;
	private boolean state;
	private float amount;
	private Date reservationDate;
	private static final long serialVersionUID = 1L;
	
	
	private User user;
	
	
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Reservation() {
		super();
	}
	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public boolean getState() {
		return this.state;
	}

	public void setState(boolean state) {
		this.state = state;
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
   
}

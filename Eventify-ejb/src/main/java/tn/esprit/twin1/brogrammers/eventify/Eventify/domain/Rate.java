package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Rate
 *
 */
@Entity
public class Rate implements Serializable {

	
	private RatePK ratePK;
	private float note;
	private User user;
	private Event event;
	
	private static final long serialVersionUID = 1L;

	public Rate() {
		super();
	}

	@EmbeddedId
	public RatePK getRatePK() {
		return ratePK;
	}

	public void setRatePK(RatePK ratePK) {
		this.ratePK = ratePK;
	}

	
	
	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="idUser",referencedColumnName="id")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="idEvent",referencedColumnName="id")
	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public float getNote() {
		return note;
	}

	public void setNote(float note) {
		this.note = note;
	}
	
	
	
	
   
}
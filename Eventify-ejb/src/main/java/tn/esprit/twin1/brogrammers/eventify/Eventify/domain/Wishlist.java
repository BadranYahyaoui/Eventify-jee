package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Wishlist
 *
 */
@Entity
@IdClass(WishlistId.class)

public class Wishlist implements Serializable {

	@Id
	private long userId;
	@Id
	private long eventId;
	private Date dateAdding;
	
	
	@ManyToOne
	@JoinColumn(name = "userId", updatable = false, insertable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "eventId", updatable = false, insertable = false)
	private Event event;
	
	private static final long serialVersionUID = 1L;

	public Wishlist() {
		super();
	}   
	public long getUserId() {
		return this.userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}   
	public long getEventId() {
		return this.eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}   
	public Date getDateAdding() {
		return this.dateAdding;
	}

	public void setDateAdding(Date dateAdding) {
		this.dateAdding = dateAdding;
	}
   
}

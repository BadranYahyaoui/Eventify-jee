package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;

public class WishlistId implements Serializable{

	  private long userId;

	  private long eventId;

	  @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (eventId ^ (eventId >>> 32));
		result = prime * result + (int) (userId ^ (userId >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistId other = (WishlistId) obj;
		if (eventId != other.eventId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}
	  
	  

	  
}

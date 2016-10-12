package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: ReferrelUser
 *
 */
@Entity
public class ReferrelUser implements Serializable {

	private ReferrelUserPK referrelUserPK;
	private User userReferred;
	private User userReferral;
	

	private static final long serialVersionUID = 1L;

	public ReferrelUser() {
		super();
	}

	@EmbeddedId
	public ReferrelUserPK getReferrelUserPK() {
		return referrelUserPK;
	}

	public void setReferrelUserPK(ReferrelUserPK referrelUserPK) {
		this.referrelUserPK = referrelUserPK;
	}

	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="idUserReferred",referencedColumnName="id")
	public User getUserReferred() {
		return userReferred;
	}

	public void setUserReferred(User userReferred) {
		this.userReferred = userReferred;
	}

	@ManyToOne
	@JoinColumn(insertable=false,updatable=false,name="idUserReferral",referencedColumnName="id")
	public User getUserReferral() {
		return userReferral;
	}

	public void setUserReferral(User userReferral) {
		this.userReferral = userReferral;
	}
	
	
	
	
   
}

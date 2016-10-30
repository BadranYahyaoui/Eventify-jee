package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;

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
	private Date dateInvitation;
	private int stateInvitation;
	

	public ReferrelUser(ReferrelUserPK referrelUserPK, User userReferred, User userReferral, Date dateInvitation,
			int stateInvitation) {
		super();
		this.referrelUserPK = referrelUserPK;
		this.userReferred = userReferred;
		this.userReferral = userReferral;
		this.dateInvitation = dateInvitation;
		this.stateInvitation = stateInvitation;
	}

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

	public Date getDateInvitation() {
		return dateInvitation;
	}

	public void setDateInvitation(Date dateInvitation) {
		this.dateInvitation = dateInvitation;
	}

	public int getStateInvitation() {
		return stateInvitation;
	}

	public void setStateInvitation(int stateInvitation) {
		this.stateInvitation = stateInvitation;
	}
	
	
	
	
   
}

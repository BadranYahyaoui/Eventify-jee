package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Organizer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
private OrganizerPK  organizerPK;
	private User user;
	private Organization organization;

	@EmbeddedId
	public OrganizerPK getOrganizerPK() {
		return organizerPK;
	}

	public void setOrganizerPK(OrganizerPK organizerPK) {
		this.organizerPK = organizerPK;
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
	@JoinColumn(insertable=false,updatable=false,name="idOrganization",referencedColumnName="id")
	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public Organizer() {
		super();
	}
	
	
	
	
	
	

}

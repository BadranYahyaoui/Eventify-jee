package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Organization
 *
 */
@Entity

public class Organization implements Serializable {
	//Saleeeem Hakim
	   
	private int id;
	private String organizationName;
	private String organizationType;
	private Date creationDate;
	private static final long serialVersionUID = 1L;
	
	private List<Event> events;
	
	
	
	public Organization() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}   
	public String getOrganizationType() {
		return this.organizationType;
	}

	public void setOrganizationType(String organizationType) {
		this.organizationType = organizationType;
	}   
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	@OneToMany(mappedBy="organization")
	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
   
	
	
}

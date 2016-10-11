package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Event
 *
 */
@Entity

public class Event implements Serializable {

	private int id;
	private String title;
	private String theme;
	private Date startTime;
	private Date endTime;
	private float longitude;
	private float latitude;
	private int placeNumber;
	private String eventType; 
	private String eventCategory;
	private int typeCreator;
	private int nbViews;
	private Date createdAt;
	private static final long serialVersionUID = 1L;
	
	private Organization organization;
	
	private List<Media> medias;
	
	//For Wishlist association
	private List<Wishlist> users;
	
	
	//Event Type Conference ,Class,Seminar,Party ...
	//Event Category Business,Food Drink Spirituality Family , Education , Health

	
	
	
	public Event() {
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
	
	
	@OneToMany(mappedBy="event")  
	public List<Media> getMedias() {
		return medias;
	}
	public void setMedias(List<Media> medias) {
		this.medias = medias;
	}
	
	
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}   
	public String getTheme() {
		return this.theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}   
	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}   
	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}   
	public float getLongitude() {
		return this.longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}   
	public float getLatitude() {
		return this.latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}   
	public int getPlaceNumber() {
		return this.placeNumber;
	}

	public void setPlaceNumber(int placeNumber) {
		this.placeNumber = placeNumber;
	}   
	public String getEventType() {
		return this.eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}   
	

	public String getEventCategory() {
		return eventCategory;
	}

	public void setEventCategory(String eventCategory) {
		this.eventCategory = eventCategory;
	}

	public int getTypeCreator() {
		return this.typeCreator;
	}

	public void setTypeCreator(int typeCreator) {
		this.typeCreator = typeCreator;
	}   
	public int getNbViews() {
		return this.nbViews;
	}

	public void setNbViews(int nbViews) {
		this.nbViews = nbViews;
	}   
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@ManyToOne
	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	
	@OneToMany(mappedBy="event")
	public List<Wishlist> getUsers() {
		return users;
	}


	public void setUsers(List<Wishlist> users) {
		this.users = users;
	}
   
	
	
	
	
}

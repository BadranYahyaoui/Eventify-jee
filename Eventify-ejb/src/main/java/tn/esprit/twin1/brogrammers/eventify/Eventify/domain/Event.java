package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

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
	
	/* 	Foreign KEY Start */
	private Organization organization;
	
	private List<Media> medias;
	

	private List<Wishlist> wishlists;
	
	private List<Rate> rate;
	
	private List<Question> questions;
	
	private List<Task> tasks;
	
	private List<Ticket> tickets;
	
	/* 	Foreign KEY END */

	//Event Type Conference ,Class,Seminar,Party ...
	//Event Category Business,Food Drink Spirituality Family , Education , Health

	
	
	
	public Event() {
		super();
	}	
	

	public Event(int id, String title, String theme, Date startTime, Date endTime, float longitude, float latitude,
			int placeNumber, String eventType, String eventCategory, int typeCreator, int nbViews, Date createdAt,
			Organization organization) {
		super();
		this.id = id;
		this.title = title;
		this.theme = theme;
		this.startTime = startTime;
		this.endTime = endTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeNumber = placeNumber;
		this.eventType = eventType;
		this.eventCategory = eventCategory;
		this.typeCreator = typeCreator;
		this.nbViews = nbViews;
		this.createdAt = createdAt;
		this.organization = organization;
	}




	public Event(int id, String title, String theme) {
		super();
		this.id = id;
		this.title = title;
		this.theme = theme;
	}




	public Event(int id, String title, String theme, Date startTime, Date endTime, float longitude, float latitude,
			int placeNumber, String eventType, String eventCategory, int typeCreator, int nbViews, Date createdAt) {
		super();
		this.id = id;
		this.title = title;
		this.theme = theme;
		this.startTime = startTime;
		this.endTime = endTime;
		this.longitude = longitude;
		this.latitude = latitude;
		this.placeNumber = placeNumber;
		this.eventType = eventType;
		this.eventCategory = eventCategory;
		this.typeCreator = typeCreator;
		this.nbViews = nbViews;
		this.createdAt = createdAt;
	}




	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
	
	@OneToMany(mappedBy="event", fetch=FetchType.LAZY)
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

	/* FOREIGN KEY Start */
	@ManyToOne(fetch=FetchType.LAZY)
	public Organization getOrganization() {
		return organization;
	}


	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	public List<Wishlist> getWishlists() {
		return wishlists;
	}


	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)
	public List<Rate> getRate() {
		return rate;
	}


	public void setRate(List<Rate> rate) {
		this.rate = rate;
	}


	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)  
	public List<Question> getQuestions() {
		return questions;
	}


	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)  
	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	@OneToMany(mappedBy="event", fetch = FetchType.LAZY)  
	public List<Ticket> getTickets() {
		return tickets;
	}


	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	
	
	
	

	
	/* FOREIGN KEY END */
	
}

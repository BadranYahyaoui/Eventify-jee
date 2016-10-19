package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: User
 * 
 * PS : DON'T FUCKING TOUCH THIS LOVELY BY HAKIM
 *
 */
@Entity

public class User implements Serializable {

	private int id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private Date creationDate;
	private int loyaltyPoint;

	private static final long serialVersionUID = 1L;

	private List<Wishlist> wishlists;
	private List<Notification> notifications;
	private List<Organization> organizations;
	private List<Reservation> reservations;
	private List<Organizer> organizers;
	private List<ReferrelUser> ReferredUsers;
	private List<ReferrelUser> ReferralUsers;
	private List<Answer> answers;
	private List<Rate> rates;

	/*********************************
	 * Constructors
	 *********************/
	public User() {
		super();
	}

	public User(int id, String firstName, String lastName, String username, String password, Date creationDate,
			int loyaltyPoint) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
		this.loyaltyPoint = loyaltyPoint;
	}
	
	public User(String firstName, String lastName, String username, String password, Date creationDate,
			int loyaltyPoint) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.creationDate = creationDate;
		this.loyaltyPoint = loyaltyPoint;
	}
	
	
	

	/*********************************
	 * End Of Constructors
	 *********************/

	/*********************************
	 * PK
	 *********************/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	/***********************************
	 * End of PK
	 ******************************/

	/**************************************
	 * Navigation Attributes
	 ******************************/
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<Organizer> organizers) {
		this.organizers = organizers;
	}

	@OneToMany(mappedBy = "userReferred", fetch = FetchType.LAZY)
	public List<ReferrelUser> getReferredUsers() {
		return ReferredUsers;
	}

	public void setReferredUsers(List<ReferrelUser> referredUsers) {
		ReferredUsers = referredUsers;
	}

	@OneToMany(mappedBy = "userReferral", fetch = FetchType.LAZY)
	public List<ReferrelUser> getReferralUsers() {
		return ReferralUsers;
	}

	public void setReferralUsers(List<ReferrelUser> referralUsers) {
		ReferralUsers = referralUsers;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	public List<Rate> getRates() {
		return rates;
	}

	public void setRates(List<Rate> rates) {
		this.rates = rates;
	}

	/*********************
	 * End of Navigation Attributes
	 ******************************/

	/**************************************
	 * Simple Attributes
	 ******************************/

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public int getLoyaltyPoint() {
		return loyaltyPoint;
	}

	public void setLoyaltyPoint(int loyaltyPoint) {
		this.loyaltyPoint = loyaltyPoint;
	}

	/*********************
	 * End of Simple Attributes
	 ******************************/

	public void assignOrganizerToThisUser(List<Organizer> organizers) {
		this.setOrganizers(organizers);
		for (Organizer o : organizers) {
			o.setUser(this);
		}
	}

}

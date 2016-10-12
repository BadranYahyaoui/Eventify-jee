package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import sun.security.util.Password;

/**
 * Entity implementation class for Entity: User
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
	private int loyaltyPoints;
	private static final long serialVersionUID = 1L;

	private List<Wishlist> wishlists;
	private List<Notification> notifications;
	private List<Organization> organizations;
	private List<Reservation> reservations;
	private List<Organizer> organizers;
	private List<ReferrelUser> ReferredUsers;
	private List<ReferrelUser> ReferralUsers;
	
	
	@OneToMany(mappedBy="userReferral")
	public List<ReferrelUser> getReferralUsers() {
		return ReferralUsers;
	}

	public void setReferralUsers(List<ReferrelUser> referralUsers) {
		ReferralUsers = referralUsers;
	}

	@OneToMany(mappedBy="userReferred")
	public List<ReferrelUser> getReferredUsers() {
		return ReferredUsers;
	}

	public void setReferredUsers(List<ReferrelUser> referredUsers) {
		ReferredUsers = referredUsers;
	}

	@OneToMany(mappedBy = "user")
	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@OneToMany(mappedBy = "user")
	public List<Organization> getOrganizations() {
		return organizations;
	}

	public void setOrganizations(List<Organization> organizations) {
		this.organizations = organizations;
	}

	
	
	@OneToMany(mappedBy = "user")
	public List<Notification> getNotifications() {
		return notifications;
	}

	public void setNotifications(List<Notification> notifications) {
		this.notifications = notifications;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	public int getLoyaltyPoints() {
		return this.loyaltyPoints;
	}

	public void setLoyaltyPoints(int loyaltyPoints) {
		this.loyaltyPoints = loyaltyPoints;
	}

	
	
	@OneToMany(mappedBy = "user")
	public List<Wishlist> getWishlists() {
		return wishlists;
	}

	public void setWishlists(List<Wishlist> wishlists) {
		this.wishlists = wishlists;
	}

	public void assignOrganizerToThisUser(List<Organizer> organizers) {
		this.setOrganizers(organizers);
		for (Organizer o : organizers) {
			o.setUser(this);
		}
	}

	@OneToMany(mappedBy = "user")
	public List<Organizer> getOrganizers() {
		return organizers;
	}

	public void setOrganizers(List<Organizer> organizers) {
		this.organizers = organizers;
	}
	

	public User() {
		super();
	}

}

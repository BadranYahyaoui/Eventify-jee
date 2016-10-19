package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

/**
 * Session Bean implementation class EventBusiness
 */
@Stateless
public class EventBusiness implements EventBusinessRemote, EventBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

	@EJB
	OrganizationBusinessLocal organizationBusiness;

	// ajout
	@Override
	public void create(Event event) {
		try {
	        entityManager.persist(event);

		} catch (Exception e) {
			System.err.println("Failed to Add");
		}

	}

	@Override
	public List<Event> getAllEvents() {
		// Query query = entityManager.createQuery("SELECT e FROM Event e");
		// return (List<Event>) query.getResultList();

		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o")
				.getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;

	}

	@Override
	public void updateEvent(Event event) {
		try {
			entityManager.merge(event);

		} catch (Exception e) {
			System.err.println("Failed to Modify");
		}
	}

	@Override
	public boolean deleteEvent(int id) {

		Iterator<Event> iterator = this.getAllEvents().iterator();
		while (iterator.hasNext()) {
			Event e = iterator.next();
			if (e.getId() == id) {
				entityManager.remove(this.findEventById(id));
				return true;
			}
		}
		return false;

	}

	@Override
	public Event findEventById(int idEvent) {
		Query query = entityManager.
				createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState) FROM Event e WHERE e.id=:param")
				.setParameter("param", idEvent);
		 return (Event) query.getSingleResult();
	}

	@Override
	public List<Event> findEventByType(String type) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o WHERE e.eventType LIKE :type")
				.setParameter("type", type)
				.getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;
	}

	@Override
	public List<Event> findEventByCategory(String category) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o WHERE e.eventCategory LIKE :category")
				.setParameter("category", category)
				.getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;
	}

	@Override
	public List<Event> findEventByPeriode(Date startTime, Date endTime) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o WHERE e.startTime = :startTime AND e.endTime = :endTime")
				.setParameter("startTime", startTime)
				.setParameter("endTime", endTime)
				.getResultList();
		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;
	}

	@Override
	public List<Event> findEventByDate(Date date) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o WHERE :date BETWEEN e.startTime AND e.endTime ")
				.setParameter("date", date)
				.getResultList();
		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;
	}

	@Override
	public List<Event> SearchForEvents(String search) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) FROM Event e JOIN e.organization o WHERE e.title LIKE :search OR e.theme LIKE :search1 ")
				.setParameter("search", '%' + search + '%')
				.setParameter("search1", '%' + search + '%')
				.getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		return events;

	}

}

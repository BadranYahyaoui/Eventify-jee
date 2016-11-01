package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import tn.esprit.twin1.brogrammers.eventify.Eventify.util.*;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.swing.event.DocumentEvent.EventType;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CategoryBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Category;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;

/**
 * Session Bean implementation class EventBusiness
 */
@Stateless
public class EventBusiness implements EventBusinessRemote, EventBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

	@EJB
	OrganizationBusinessLocal organizationBusiness;

	@EJB
	CategoryBusinessLocal categoryBusiness;

	@EJB
	QuestionBusinessLocal questionBusiness;
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
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType," + "c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) " + "FROM Event e "
						+ "JOIN e.organization o JOIN e.category c")
				.getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
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

		try {
			entityManager.remove(entityManager.find(Event.class, id));
			return true;

		} catch (Exception e) {
			System.err.println("Failed to delete");

			return false;
		}
			
		

	}

	@Override
	public Event findEventById(int idEvent) {

		try {
			Query query = entityManager.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
					+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,c,"
					+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState) "
					+ "FROM Event e JOIN e.category c " + "WHERE e.id=:param").setParameter("param", idEvent);
			Event e = (Event) query.getSingleResult();

			Category category = categoryBusiness.findById(e.getCategory().getId());
			e.setCategory(category);
			return e;

		} catch (Exception e) {
			System.err.println("Failed to find the event");
			return null;
		}
	}

	@Override
	public List<Event> findEventByType(EventType type) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType," + "c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) "
						+ "FROM Event e JOIN e.organization o JOIN e.category c " + "WHERE e.eventType LIKE :type")
				.setParameter("type", type).getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;
	}

	@Override
	public List<Event> findEventByCategory(String categoryName) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType," + "c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) " + "FROM Event e "
						+ "JOIN e.organization o " + "JOIN e.category c " + "WHERE c.categoryName LIKE :category")
				.setParameter("category", categoryName).getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;
	}

	@Override
	public List<Event> findEventByPeriode(Date startTime, Date endTime) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType," + "c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) "
						+ "FROM Event e JOIN e.organization o JOIN e.category c "
						+ "WHERE e.startTime = :startTime AND e.endTime = :endTime")
				.setParameter("startTime", startTime).setParameter("endTime", endTime).getResultList();
		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;
	}

	@Override
	public List<Event> findEventByDate(Date date) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType," + "c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) "
						+ "FROM Event e JOIN e.organization o JOIN e.category c "
						+ "WHERE :date BETWEEN e.startTime AND e.endTime ")
				.setParameter("date", date).getResultList();
		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;
	}

	@Override
	public List<Event> SearchForEvents(String search) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o) "
						+ "FROM Event e JOIN e.organization o JOIN e.category c "
						+ "WHERE e.title LIKE :search OR e.theme LIKE :search1 ")
				.setParameter("search", '%' + search + '%').setParameter("search1", '%' + search + '%').getResultList();

		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;

	}

	@Override
	public List<Event> getPopularEvents() {

		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,"
						+ "e.startTime,e.endTime,e.longitude,e.latitude,"
						+ "e.placeNumber,e.eventType,e.nbViews,e.createdAt,"
						+ "e.facebookLink,e.twitterLink,"
						+ "e.eventState,AVG(r.note),o,c) FROM Event e "
						+ "JOIN e.organization o "
						+ "JOIN e.category c "
						+ "JOIN e.rates r "
						+ "GROUP BY e.id" )
				.getResultList();

		return events;

	}

	@Override
	public List<Event> findEventNearBy(double myLongitude, double myLatitude) {
		List<Event> events = getAllEvents();
		List<Event> nearByEvents = new ArrayList<>();
		for (Event event : events) {

			if (Distance.distance(myLatitude, myLongitude, event.getLatitude(), event.getLongitude()) < 1) {
				nearByEvents.add(event);
			}
		}
		return nearByEvents;
	}

	@Override
	public List<Event> getFavoriteEventByUser(int idUser) {
		List<Event> events = (List<Event>) entityManager
				.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,c,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState,o)" + "FROM Event e "
						+ "JOIN e.organization o JOIN e.category c "
						+ "JOIN c.favorites f "
						+ "WHERE f.favoritePK.userId = :userId " + "ORDER BY f.priority")
				.setParameter("userId", idUser).getResultList();
		for (Event event : events) {
			Organization organization = organizationBusiness.findOrganizationById(event.getOrganization().getId());
			event.setOrganization(organization);
		}

		for (Event event : events) {
			Category category = categoryBusiness.findById(event.getCategory().getId());
			event.setCategory(category);
		}

		return events;
	}

	@Override
	public List<Question> getMyQuestions(int id) {
		List<Question> questions = (List<Question>) entityManager.createQuery
				("SELECT new Question(q.id,q.questionDescription,q.questionType,"
						+ "q.questionCategory,q.status,q.questionDate,q.order) FROM Event e "
						+ "JOIN e.questions q WHERE e.id=:param")
				.setParameter("param", id).getResultList();
		

		return questions;
		
		
	}

}

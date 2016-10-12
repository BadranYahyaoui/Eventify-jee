package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

/**
 * Session Bean implementation class EventBusiness
 */
@Stateless
public class EventBusiness implements EventBusinessRemote, EventBusinessLocal {

	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

//ajout
	@Override
	public void create(Event event) {
		entityManager.persist(event);
		
	}

	@Override
	public List<Event> getAllEvents() {
	    Query query = entityManager.createQuery("SELECT e FROM Event e");
	    return (List<Event>) query.getResultList();
	}

	@Override
	public void updateEvent(Event event) {
		entityManager.merge(event);	
	}

	@Override
	public void deleteEvent(Event event) {
		entityManager.remove(event);
		
	}

	@Override
	public Event findEventById(int idEvent) {
		return entityManager.find(Event.class, idEvent);
	}

	@Override
	public List<Event> findEventByType(String type) {
	    Query query = entityManager
	    		.createQuery("SELECT e FROM Event e WHERE e.eventType LIKE :type")
	    		.setParameter("type", type);
	    return (List<Event>) query.getResultList();
	}

	@Override
	public List<Event> findEventByCategory(String category) {
	    Query query = entityManager
	    		.createQuery("SELECT e FROM Event e WHERE e.eventCategory LIKE :category")
	    		.setParameter("category", category);
	    return (List<Event>) query.getResultList();
	}


	@Override
	public List<Event> findEventByOrganization(Organization organization) {
	    Query query = entityManager
	    		.createQuery("SELECT e FROM Event e WHERE e.organization.id = :organizationId")
	    		.setParameter("organizationId", organization.getId());
	    return (List<Event>) query.getResultList();
	}

	@Override
	public List<Event> findEventByPeriode(Date startTime, Date endTime) {
	    Query query = entityManager
	    		.createQuery("SELECT e FROM Event e WHERE e.startTime = :startTime AND e.endTime = :endTime")
	    		.setParameter("startTime", startTime)
	    		.setParameter("endTime", endTime);
	    return (List<Event>) query.getResultList();
	}

	@Override
	public List<Event> findEventByDate(Date date) {
	    Query query = entityManager
	    		.createQuery("SELECT e FROM Event e WHERE :date BETWEEN e.startTime AND e.endTime ")
	    		.setParameter("date", date);
	    return (List<Event>) query.getResultList();
	}

}

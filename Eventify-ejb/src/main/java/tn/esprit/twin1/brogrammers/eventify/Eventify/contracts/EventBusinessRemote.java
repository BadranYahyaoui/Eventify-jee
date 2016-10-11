package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

@Remote
public interface EventBusinessRemote {
	public void create(Event event);
	public List<Event> getAllEvents();
	public void updateEvent(Event event);
	public void deleteEvent(Event event);
	public Event findEventById(int idEvent);
	public List<Event> findEventByType(String type);
	public List<Event> findEventByCategory(String category);
	public List<Event> findEventByPeriode(Date startTime,Date endTime);
	public List<Event> findEventByDate(Date date);
	public List<Event> findEventByOrganization(Organization organization);

}

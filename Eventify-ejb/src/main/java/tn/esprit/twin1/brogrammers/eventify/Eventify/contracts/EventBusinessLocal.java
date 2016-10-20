package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

@Local
public interface EventBusinessLocal {
	public void create(Event event);
	public List<Event> getAllEvents();
	public void updateEvent(Event event);
	public boolean deleteEvent(int id);
	public Event findEventById(int idEvent);
	public List<Event> findEventByType(String type);
	public List<Event> findEventByCategory(String category);
	public List<Event> findEventByPeriode(Date startTime,Date endTime);
	public List<Event> findEventByDate(Date date);
	public List<Event> findEventNearBy(double myLongitude,double myLatitude);
	public List<Event> SearchForEvents(String search);
	public List<Event> getPopularEvents();
	

}

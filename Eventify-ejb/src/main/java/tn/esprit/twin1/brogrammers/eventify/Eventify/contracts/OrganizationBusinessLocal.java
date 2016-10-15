package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

@Local
public interface OrganizationBusinessLocal {
	public void create(Organization organization);
	public void updateOrganization(Organization organization);
	public void deleteOrganization(int id);
	public List<Organization> getAllOrganizations();
	public Organization findOrganizationById(int id);
	public List<Organization> findOrganizationByType(String type);
	public List<Organization> findOrganizationByName(String name);
	//public List<Organization> findOrganizationByEvent(Event event);
	public List<Event> getMyEvents(int id);

}

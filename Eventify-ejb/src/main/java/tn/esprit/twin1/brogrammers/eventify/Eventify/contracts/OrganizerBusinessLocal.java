package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organizer;

@Local
public interface OrganizerBusinessLocal {
	public void updateOrganizer(Organizer organizer);
	public void deleteOrganizer(int id);
	public List<Organizer> getAllOrganizers();
	public List<Organizer> getAllOrganizersByOrganization(Organization organizations);
	public List<Organization> SearchForOrganizers(String search);
	public Organization findOrganizerById(int id);

}

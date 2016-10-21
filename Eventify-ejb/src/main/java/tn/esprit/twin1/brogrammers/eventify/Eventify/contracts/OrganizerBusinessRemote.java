package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organizer;

@Remote
public interface OrganizerBusinessRemote {
	public void updateOrganizer(Organizer organizer);
	public boolean deleteOrganizer(int id);
	public Organizer getOrganizerById(int id);
	public List<Organizer> getAllOrganizersByOrganization(int OrganizationId);
	//public List<Organizer> getAllOrganizersByOrganization(Organization organization);
	public List<Organization> SearchForOrganizers(String search);
	public Organization findOrganizerById(int id);
}

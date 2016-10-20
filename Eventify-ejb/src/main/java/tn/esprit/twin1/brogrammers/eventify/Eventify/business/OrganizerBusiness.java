package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizerBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizerBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organizer;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class OrganizerBusiness
 */
@Stateless
public class OrganizerBusiness implements OrganizerBusinessRemote, OrganizerBusinessLocal {

	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public OrganizerBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void updateOrganizer(Organizer organizer) {
		entityManager.merge(organizer);
		
	}

	@Override
	public void deleteOrganizer(int id) {
		entityManager.remove(findOrganizerById(id));
		
	}

	@Override
	public List<Organizer> getAllOrganizers() {
		Query query = entityManager.createQuery("SELECT o FROM Organizer o");
		return (List<Organizer>) query.getResultList();
	}

	@Override
	//a voir erreur
	public List<Organizer> getAllOrganizersByOrganization(Organization organization) {
		   Query query = entityManager
		    		.createQuery("SELECT o FROM Organizer o WHERE o.organization.id = :organizationId")
		    		.setParameter("organizationId", organization.getId());
		    return (List<Organizer>) query.getResultList();
	}

	@Override
	public List<Organization> SearchForOrganizers(String search) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Organization findOrganizerById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}

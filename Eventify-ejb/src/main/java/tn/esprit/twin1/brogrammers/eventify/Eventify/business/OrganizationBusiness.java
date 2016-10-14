package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class OrganizationBusiness
 */
@Stateless
public class OrganizationBusiness implements OrganizationBusinessRemote, OrganizationBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
    /**
     * Default constructor. 
     */
    public OrganizationBusiness() {}

	@Override
	public void create(Organization organization) {
		entityManager.persist(organization);
		
	}

	@Override
	public void updateOrganization(Organization organization) {
		entityManager.merge(organization);
		
	}

	@Override
	public void deleteOrganization(int id) {
		entityManager.remove(findOrganizationById(id));
	}

	@Override
	public List<Organization> getAllOrganizations() {
		Query query = entityManager.createQuery("SELECT o FROM Organization o");
	    return (List<Organization>) query.getResultList();
	}

	@Override
	public Organization findOrganizationById(int id) {
		return entityManager.find(Organization.class, id);
	}

	@Override
	public List<Organization> findOrganizationByType(String type) {
		Query query = entityManager
	    		.createQuery("SELECT o FROM Organization o WHERE o.organizationType LIKE :type")
	    		.setParameter("type", type);
	    return (List<Organization>) query.getResultList();
	}

	@Override
	public List<Organization> findOrganizationByName(String name) {
		Query query = entityManager
	    		.createQuery("SELECT o FROM Organization o WHERE o.organizationName LIKE :name")
	    		.setParameter("name", name);
	    return (List<Organization>) query.getResultList();
	}

}

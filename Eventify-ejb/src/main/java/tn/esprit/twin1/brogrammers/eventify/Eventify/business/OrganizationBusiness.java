package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;

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
		Query query = entityManager.createQuery
				("SELECT new Organization(o.id,o.organizationName,o.organizationType,o.creationDate) FROM Organization o");
	    return (List<Organization>) query.getResultList();
	}

	@Override
	public Organization findOrganizationById(int id) {
		Query query = entityManager.
				createQuery("SELECT new Organization(o.id,o.organizationName,o.organizationType,o.creationDate) FROM Organization o WHERE o.id=:param")
				.setParameter("param", id);
		 return (Organization) query.getSingleResult();
		
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
	
	public List<Event> getMyEvents(int id){
		 Query query = entityManager.createQuery("SELECT new Event(e.id,e.title,e.theme,e.startTime,"
						+ "e.endTime,e.longitude,e.latitude,e.placeNumber,e.eventType,e.eventCategory,"
						+ "e.nbViews,e.createdAt,e.facebookLink,e.twitterLink,e.eventState) FROM Organization o JOIN o.events e WHERE o.id=:param");
		    return (List<Event>) query.setParameter("param", id).getResultList();
	}

	@Override
	public List<Organization> SearchForOrganizations(String search) {
		Query query = entityManager
	    		.createQuery("SELECT o FROM Organization o WHERE o.organizationName LIKE :search OR o.organizationType LIKE :search1 ")
	    		.setParameter("search",'%' +search +'%')
	    		.setParameter("search1",'%' +search +'%');
	    return (List<Organization>) query.getResultList();
	}
	
	

}

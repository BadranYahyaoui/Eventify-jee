package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.ArrayList;
import java.util.Iterator;
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
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

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
	public void assignOrganizer(Organizer organizer) {
		try {
			entityManager.persist(organizer);
		} catch (Exception e) {
			System.err.println("error");
		}
		
	}
    
    
	@Override
	public void updateOrganizer(Organizer organizer) {
		entityManager.merge(organizer);
		
	}



	@Override
	public List<Organizer> getAllOrganizersByOrganization(int OrganizationId) {
		
	  
		    try {
				Query query = entityManager.
						createQuery("SELECT new Organizer(o.organizerPK) FROM Organizer o WHERE o.organizerPK.idOrganization=:param")
						.setParameter("param", OrganizationId);
				 return query.getResultList();

			} catch (Exception e) {
				System.err.println("Cant Find Organizer");
				return new ArrayList<Organizer>();
			}
	
	}



	

	@Override
	public boolean deleteOrganizer(int UserId, int OrganizationId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Organizer> getAllOrganizersByUser(int UserId) {
		  try {
				Query query = entityManager.
						createQuery("SELECT new Organizer(o.organizerPK) FROM Organizer o WHERE o.organizerPK.idUser=:param")
						.setParameter("param", UserId);
				 return query.getResultList();

			} catch (Exception e) {
				System.err.println("Cant Find Organizer");
				return new ArrayList<Organizer>();
			}
	}

	@Override
	public Organizer getAllOrganizersByUserIdAndOrganizationId(int UserId, int OrganizationId) {
		try {
			Query query = entityManager.
					createQuery("SELECT new Organizer(o.organizerPK,o.State) FROM Organizer o"
							+ " WHERE o.organizerPK.idOrganization=:OrganizationId AND o.organizerPK.idUser=:UserId")
			.setParameter("OrganizationId", OrganizationId)
			.setParameter("UserId", UserId);
			 return (Organizer) query.getSingleResult();

		} catch (Exception e) {
			System.err.println("Cant Find Organizer");
			return null; } 
		}
	
	
	
	}



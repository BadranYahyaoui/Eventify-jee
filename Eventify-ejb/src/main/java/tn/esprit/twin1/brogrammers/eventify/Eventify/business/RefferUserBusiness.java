package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RefferUserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RefferUserBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

/**
 * Session Bean implementation class RefferUserBusiness
 */
@Stateless
@LocalBean
public class RefferUserBusiness implements RefferUserBusinessRemote, RefferUserBusinessLocal {

    /**
     * Default constructor. 
     */
	

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	
	@EJB
	OrganizationBusinessLocal organizationBusiness;

    public RefferUserBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public User ChooseReferralUser(User userReferral) {
		
		User query = (User) entityManager.createQuery("SELECT u FROM User u WHERE u.Id=userReferral.Id");
		return query;
	}

	@Override
	public User FindReferral(int Id) {
		
		
		
		return entityManager.find(User.class, Id);
	}

	@Override
	public User FindRefered(User userReferral) {
		
		 return entityManager.find(User.class, userReferral.getId());
	}

	@Override
	public void RemoveReferred(User userReferral) {
		entityManager.remove(userReferral);
		
	}

	@Override
	public List<User> FindAllReferral() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateReffered(User Referred) {

     entityManager.merge(Referred);
		
	}
    

    

}

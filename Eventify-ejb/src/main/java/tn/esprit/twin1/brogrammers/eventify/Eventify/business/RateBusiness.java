package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;

/**
 * Session Bean implementation class RateBusiness
 */
@Stateless
@LocalBean
public class RateBusiness implements RateBusinessRemote, RateBusinessLocal {

    /**
     * Default constructor. 
     */
	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	
    public RateBusiness() {
        
    }

	@Override
	public void createRate(Rate rate) {
		entityManager.persist(rate);
		
	}

	@Override
	public void modifyRate(Rate rate) {
		entityManager.merge(rate);
		
		
	}

}

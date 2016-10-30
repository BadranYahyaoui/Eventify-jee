package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Answer;
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

	@Override
	public boolean deleteRate(int id) {
		try {
			entityManager.remove(getRateByUserId(id));
			return true;
		} catch (Exception e) {
			System.err.println("Failed To Delete");
			return false;
		}
	}

	@Override
	public List<Rate> getRateByUserId(int id) {
		try {
			Query query = entityManager.
					createQuery("SELECT new Rate(r.RatePK,r.note) FROM Rate r WHERE r.RatePK.idUser=:param")
					.setParameter("param", id);
			 return (List<Rate>) query.getResultList();

		} catch (Exception e) {
			System.err.println("Cant Find Answer");
			return new ArrayList<Rate>();
		}
	}

}

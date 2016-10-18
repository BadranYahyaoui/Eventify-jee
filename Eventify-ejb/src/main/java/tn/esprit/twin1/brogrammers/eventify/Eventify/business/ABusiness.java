package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;

/**
 * Session Bean implementation class Abusiness
 */
@Stateless
@LocalBean
public class ABusiness implements ABusinessLocal,ABusinessRemote {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
    public ABusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<A> getAllA() {
		Query query = entityManager.createQuery("SELECT t FROM A t");
	    return (List<A>) query.getResultList();
	}

	@Override
	public A findAbyid(int id) {
		// TODO Auto-generated method stub
		  Query query = entityManager.createQuery("SELECT new A(a.id,a.nameA) FROM A a WHERE a.idA=:param");
		    return (A) query.setParameter("param", id).getSingleResult();
	}

	@Override
	public List<AA> findAAListById(int id) {
		// TODO Auto-generated method stub
		 Query query = entityManager.createQuery("SELECT new AA(aa.idAA,aa.nameAA) FROM A a JOIN a.aas aa WHERE a.idA=:param");
		    return (List<AA>) query.setParameter("param", id).getResultList();
	}

}

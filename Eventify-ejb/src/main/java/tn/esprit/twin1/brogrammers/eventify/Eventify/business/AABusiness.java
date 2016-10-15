package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AABusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;

/**
 * Session Bean implementation class AABusiness
 */
@Stateless
@LocalBean
public class AABusiness implements AABusinessRemote, AABusinessLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	@EJB
	ABusinessLocal ab;

	public AABusiness() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<AA> getAllAA() {
		List<AA> aa= (List<AA>) entityManager.createQuery("SELECT new AA(aa.idAA,aa.nameAA,a)  FROM AA aa  JOIN  aa.a a  ").getResultList();
		
		for (AA aaa : aa) {
			A a=ab.findAbyid(aaa.getA().getIdA());
			
			aaa.setA(a);
		}
		
		
		return aa;
		
	}

}

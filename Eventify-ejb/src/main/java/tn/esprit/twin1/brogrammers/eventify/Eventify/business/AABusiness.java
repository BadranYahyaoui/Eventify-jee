package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AABusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ABusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;

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
		
		
		/*
		List<AA> aa = null;
		Query query = entityManager.createQuery("SELECT t FROM AA t JOIN FETCH t.a");
		A as = new A(1, "");
		AA cc = new AA(1,"2",as);
		aa.add(cc);
		for (int i = 0; i < query.getResultList().size(); i++)
		{
			aa.add((AA)query.getSingleResult());
			
		}
		
		return aa;
		*/
	}


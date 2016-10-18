package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;

/**
 * Session Bean implementation class TransactionBusiness
 */
@Stateless
@LocalBean
public class TransactionBusiness implements ITransactionBusinessRemote, ITransactionBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	
    @Override
	public List<Transaction> getAllTransactions() {
    	Query query = entityManager.createQuery("SELECT t FROM Transaction t");
	    return (List<Transaction>) query.getResultList();
		
	}
}

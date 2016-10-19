package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Reservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RowTicketReservation;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;

/**
 * Session Bean implementation class TransactionBusiness
 */
@Stateless
@LocalBean
public class TransactionBusiness implements ITransactionBusinessRemote, ITransactionBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
	@EJB
	IReservationBusinessLocal reservationbusinessloccal;
	
    @Override
	public List<Transaction> getAllTransactions() {
    	List<Transaction> transaction= (List<Transaction>) entityManager.createQuery("SELECT new Transaction(t.id,t.token,t.amount,reservation) "
						+ "FROM Transaction t JOIN t.reservation reservation").getResultList();
    	
    	
    	for (Transaction transactions : transaction) {
			
			
			Reservation reservation = reservationbusinessloccal.findReservationById(transactions.getReservation().getId());
			transactions.setReservation(reservation);

		
			
		}
	    return transaction;
		
	}


	@Override
	public void create(Transaction transaction) {
		entityManager.persist(transaction);
		
	}


	@Override
	public void updateTransaction(Transaction transaction) {
		entityManager.merge(transaction);	
		
	}


	@Override
	public boolean deleteTransaction(Transaction transaction) {
		entityManager.remove(entityManager.merge(transaction));
		return true;
	}


	@Override
	public boolean deleteTransactionById(int id) {
		Iterator<Transaction> iterator=this.getAllTransactions().iterator();
		while(iterator.hasNext()){
			Transaction t=iterator.next();
			if(t.getId()==id){
				entityManager.remove(this.findTransactionById(id));
				return true;
			}
		}
		return false;
	}


	@Override
	public Transaction findTransactionById(int idtransaction) {
		return entityManager.find(Transaction.class, idtransaction);
	}
}

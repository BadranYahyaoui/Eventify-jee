package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Ticket;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;

@Remote
public interface ITransactionBusinessRemote {
	List<Transaction> getAllTransactions();
	public void create(Transaction transaction);
	public void updateTransaction(Transaction transaction);
	public boolean deleteTransaction(Transaction transaction);
	public boolean deleteTransactionById(int id);
	public Transaction findTransactionById(int idtransaction);
}

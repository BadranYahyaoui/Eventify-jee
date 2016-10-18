package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Transaction;

@Remote
public interface ITransactionBusinessRemote {
	List<Transaction> getAllTransactions();
}

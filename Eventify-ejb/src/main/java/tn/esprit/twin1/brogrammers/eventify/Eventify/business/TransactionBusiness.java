package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITransactionBusinessRemote;

/**
 * Session Bean implementation class TransactionBusiness
 */
@Stateless
@LocalBean
public class TransactionBusiness implements ITransactionBusinessRemote, ITransactionBusinessLocal {

    /**
     * Default constructor. 
     */
    public TransactionBusiness() {
        // TODO Auto-generated constructor stub
    }

}

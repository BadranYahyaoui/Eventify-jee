package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IRowTicketReservationBusinessRemote;

/**
 * Session Bean implementation class RowTicketReservationBusiness
 */
@Stateless
@LocalBean
public class RowTicketReservationBusiness implements IRowTicketReservationBusinessRemote, IRowTicketReservationBusinessLocal {

    /**
     * Default constructor. 
     */
    public RowTicketReservationBusiness() {
        // TODO Auto-generated constructor stub
    }

}

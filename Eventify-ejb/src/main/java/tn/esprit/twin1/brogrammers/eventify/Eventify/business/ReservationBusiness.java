package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.IReservationBusinessRemote;

/**
 * Session Bean implementation class ReservationBusiness
 */
@Stateless
@LocalBean
public class ReservationBusiness implements IReservationBusinessRemote, IReservationBusinessLocal {

    /**
     * Default constructor. 
     */
    public ReservationBusiness() {
        // TODO Auto-generated constructor stub
    }

}

package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.ITicketBusinessRemote;

/**
 * Session Bean implementation class TicketBusiness
 */
@Stateless
@LocalBean
public class TicketBusiness implements ITicketBusinessRemote, ITicketBusinessLocal {

    /**
     * Default constructor. 
     */
    public TicketBusiness() {
        // TODO Auto-generated constructor stub
    }

}

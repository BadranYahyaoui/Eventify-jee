package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizerBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizerBusinessRemote;

/**
 * Session Bean implementation class OrganizerBusiness
 */
@Stateless
public class OrganizerBusiness implements OrganizerBusinessRemote, OrganizerBusinessLocal {

    /**
     * Default constructor. 
     */
    public OrganizerBusiness() {
        // TODO Auto-generated constructor stub
    }

}

package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessRemote;

/**
 * Session Bean implementation class OrganizationBusiness
 */
@Stateless
public class OrganizationBusiness implements OrganizationBusinessRemote, OrganizationBusinessLocal {

    /**
     * Default constructor. 
     */
    public OrganizationBusiness() {
        // TODO Auto-generated constructor stub
    }

}

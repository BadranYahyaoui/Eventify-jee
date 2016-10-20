package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CommentBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CommentBusinessRemote;

/**
 * Session Bean implementation class CommentBusiness
 */
@Stateless
@LocalBean
public class CommentBusiness implements CommentBusinessRemote, CommentBusinessLocal {

    /**
     * Default constructor. 
     */
    public CommentBusiness() {
        // TODO Auto-generated constructor stub
    }

}

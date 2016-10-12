package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

/**
 * Session Bean implementation class WishlistBusiness
 */
@Stateless
public class WishlistBusiness implements WishlistBusinessRemote, WishlistBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

	@Override
	public void addEventToWishlist(Event event, User user) {
		Wishlist wishlist = new Wishlist(event, user);
		entityManager.merge(wishlist);
		
	}

    

}

package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	public void addEventToWishlist(Wishlist wishlist) {
		entityManager.merge(wishlist);
		
	}

	@Override
	public boolean RemoveEventFromWishlist(int id) {
		
		if(getWishlistById(id)!=null)
		{
			entityManager.remove(getWishlistById(id));;
			return true;
		}
		else
		return false;
			
		
		
	}

	@Override
	public List<Wishlist> getWishlistByUser(int userId) {
		System.err.println("************ ID User  *******" + userId);
	    Query query = entityManager
	    		.createQuery("SELECT w FROM Wishlist w WHERE w.wishlistPK.userId = :userId")
	    		.setParameter("userId", userId);
	    return (List<Wishlist>) query.getResultList();
		
	}

	@Override
	public Wishlist getWishlistById(int id) {
		return entityManager.find(Wishlist.class, id);
	}

    

}

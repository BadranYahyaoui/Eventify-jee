package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

@Remote
public interface WishlistBusinessRemote {
	public void addEventToWishlist(Wishlist wishlist);
	public void RemoveEventFromWishlist(Wishlist wishlist);
	public List<Wishlist> getWishlistByUser(int userId);

}

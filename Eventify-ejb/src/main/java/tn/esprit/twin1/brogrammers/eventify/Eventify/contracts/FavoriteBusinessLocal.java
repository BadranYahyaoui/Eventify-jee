package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Favorite;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

@Local
public interface FavoriteBusinessLocal {
	
	public void addFavorite(Favorite favorite);
	public boolean RemoveFavorite(Favorite favorite);
	public Favorite getFavoriteByUserAndCategory(int userId,int categoryId);

}

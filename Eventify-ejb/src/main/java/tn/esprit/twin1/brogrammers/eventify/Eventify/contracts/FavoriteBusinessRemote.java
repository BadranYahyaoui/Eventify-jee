package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Favorite;

@Remote
public interface FavoriteBusinessRemote {

	public void addFavorite(Favorite favorite);
	public boolean RemoveFavorite(Favorite favorite);
	public Favorite getFavoriteByUserAndCategory(int userId,int categoryId);

}

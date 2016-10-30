package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.FavoriteBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.FavoriteBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Favorite;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

/**
 * Session Bean implementation class FavoriteBusiness
 */
@Stateless
@LocalBean
public class FavoriteBusiness implements FavoriteBusinessRemote, FavoriteBusinessLocal {

 
	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

    public FavoriteBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addFavorite(Favorite favorite) {
		try {
			entityManager.persist(favorite);

		} catch (Exception e) {
			System.out.println("unable to add a favorite");
		}
		
	}

	@Override
	public boolean RemoveFavorite(Favorite favorite) {
		return false;
	}

	@Override
	public Favorite getFavoriteByUserAndCategory(int userId, int categoryId) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

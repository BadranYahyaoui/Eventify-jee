package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;

/**
 * Session Bean implementation class UserBusiness
 * 
 * PS : DON'T FUCKING TOUCH THIS LOVELY BY HAKIM
 */
@Stateless
public class UserBusiness implements UserBusinessRemote, UserBusinessLocal {

	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

	public UserBusiness() {

	}

	@Override
	public void createUser(User user) {

		entityManager.merge(user);

	}

	@Override
	public User findUserById(int id) {

		return entityManager.find(User.class, id);
	}

	@Override
	public List<User> findAllUsers() {
		Query query = entityManager.createQuery("SELECT u FROM User u");
		return (List<User>) query.getResultList();
	}

	@Override
	public void updateUser(User user) {

		entityManager.merge(user);

	}

	@Override
	public void deleteUser(int id) {
		entityManager.remove(findUserById(id));

	}
	//added by Ibra
	public List<Wishlist> getMyWishlist(int idUser){
		 Query query = entityManager.createQuery("SELECT new Wishlist(w.dateAdding) "
		 		+ "FROM User u JOIN u.wishlists w WHERE u.id=:param");
		    return query.setParameter("param", idUser).getResultList();
	}

	
	
}

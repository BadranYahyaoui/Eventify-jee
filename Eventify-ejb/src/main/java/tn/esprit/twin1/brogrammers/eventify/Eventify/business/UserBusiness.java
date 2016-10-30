package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.AccountState;
import tn.esprit.twin1.brogrammers.eventify.Eventify.util.AuthJWT;
import tn.esprit.twin1.brogrammers.eventify.Eventify.util.MD5Hash;

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
		user.setPassword(MD5Hash.getMD5Hash(user.getPassword()));
		user.setAccountState(AccountState.NOTACTIVATED);
		String activationHashedCode = MD5Hash.getMD5Hash(user.getUsername() + user.getEmail());
		user.setConfirmationToken(activationHashedCode);
		// Emailer.sendEmail("Eventify Account Activation",
		// "http://localhost:18080/Eventify-web/rest/users/confirm/"+activationHashedCode,
		// user.getEmail());
		entityManager.persist(user);
		// Emailer.SendEmail(user.getEmail(), "Eventify Account Activation",
		// EmailTemplate.activiationTemplate("http://localhost:18080/Eventify-web/rest/users/confirm/"+activationHashedCode));

	}

	@Override
	public boolean activateAccount(String confirmationToken) {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.confirmationToken) " + "FROM User u WHERE u.confirmationToken=:param");
		User u = null;
		try {
			u = (User) query.setParameter("param", confirmationToken).getSingleResult();

			if (u != null && u.getConfirmationToken().equals(confirmationToken)) {
				User userTochange = findUserById(u.getId());
				userTochange.setAccountState(AccountState.ACTIVATED);
				updateUser(userTochange);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			System.out.println("\n\n\n\n\n\n confirmationToken Not Found | User Not Set \n\n\n\n\n\n ");
			return false;
		}

	}

	@Override
	public User findUserById(int id) {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstName,u.lastName,u.username,u.email,u.password,u.creationDate,u.loyaltyPoint,u.accountState,u.confirmationToken) "
						+ "FROM User u WHERE u.id=:param");
		return (User) query.setParameter("param", id).getSingleResult();
	}

	@Override
	public List<User> findAllUsers() {
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstName,u.lastName,u.username,u.email,u.password,u.creationDate,u.loyaltyPoint,u.accountState,u.confirmationToken) "
						+ "FROM User u");
		return (List<User>) query.getResultList();
	}

	@Override
	public void updateUser(User user) {

		entityManager.merge(user);

	}

	@Override
	public void deleteUser(int id) {
		// entityManager.remove(findUserById(id));
		entityManager.remove(entityManager.find(User.class, id));

	}

	@Override
	public String loginUser(String username, String pwd) {
		String hashedPwd=MD5Hash.getMD5Hash(pwd);
		Query query = entityManager.createQuery(
				"SELECT new User(u.id,u.firstName,u.lastName,u.username,u.email,u.password,u.creationDate,u.loyaltyPoint,u.accountState,u.confirmationToken) "
						+ "FROM User u WHERE (u.username=:uname AND u.password=:upwd) ");
		User userLogged =(User) query.setParameter("uname", username).setParameter("upwd", hashedPwd).getSingleResult();
		
		
		return AuthJWT.SignJWT();

	}

	@Override
	public List<Wishlist> getMyWishlist(int idUser) {
		Query query = entityManager
				.createQuery("SELECT new Wishlist(w.dateAdding) FROM User u JOIN u.wishlists w WHERE u.id=:param");
		return query.setParameter("param", idUser).getResultList();
	}

}

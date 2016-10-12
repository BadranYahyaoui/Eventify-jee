package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Remote
public interface UserBusinessRemote {
	
	public void createUser(User user);
	public User findUserById(int id);
	public List<User> findAllUsers();
	public void updateUser(User user);
	public void deleteUser(int id);

}

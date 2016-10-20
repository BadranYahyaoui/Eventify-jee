package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Local
public interface RefferUserBusinessLocal {
	
	public User ChooseReferralUser(User userReferral);
	public User FindReferral(User userReferred);
	public User FindRefered(User userReferral);
	public void RemoveReferred(User userReferral);
	public List<User> FindAllReferral();
	public void updateReffered(User Referred);

}

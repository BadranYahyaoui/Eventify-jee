package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Remote
public interface RefferUserBusinessRemote {
	
	public User ChooseReferralUser(User userReferral);
	public User FindReferral(int Id);
	public User FindRefered(User userReferral);
	public void RemoveReferred(User userReferral);
	public List<User> FindAllReferral();
	public void updateReffered(User Referred);

}

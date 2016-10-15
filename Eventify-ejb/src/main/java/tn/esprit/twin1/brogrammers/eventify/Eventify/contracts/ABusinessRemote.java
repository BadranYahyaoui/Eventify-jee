package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.A;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AA;

@Remote
public interface ABusinessRemote {
	public List<A> getAllA();
	public A findAbyid(int id);
	public List<AA> findAAListById(int id);
}

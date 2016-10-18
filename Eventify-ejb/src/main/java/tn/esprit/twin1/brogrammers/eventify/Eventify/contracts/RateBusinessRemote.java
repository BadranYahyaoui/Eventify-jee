package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;

@Remote
public interface RateBusinessRemote {
		
	public void createRate(Rate rate);
	
	public void modifyRate(Rate rate);
	
}

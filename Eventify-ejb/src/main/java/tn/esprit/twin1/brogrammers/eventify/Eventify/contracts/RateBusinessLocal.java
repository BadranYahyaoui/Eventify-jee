package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;

@Local
public interface RateBusinessLocal {
	
	public void createRate(Rate rate);
	
	public void modifyRate(Rate rate);

}

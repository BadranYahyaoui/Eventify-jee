package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;

@Remote
public interface RateBusinessRemote {
		
public void createRate(Rate rate);
	
	public void modifyRate(Rate rate);
	
	public boolean deleteRate(int id);
	
	public List<Rate> getRateByUserId(int id);
	
	public float CalculRate(Event event);
	
	public List<Rate> GetAllRatesOfEvent(int id);
	
	public List<Rate> getAllRates();
}
	

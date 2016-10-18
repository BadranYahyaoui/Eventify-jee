package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;

@Singleton
@Startup
public class DBPopulator {
	
	@EJB
	UserBusinessLocal userBusines;
	
	
	public DBPopulator() {
	}
	
	@PostConstruct
	public void init(){
		
		User u1 = new User("Hakim", "Mliki", "kimo", "123456",new Date(), 1);
		User u2 = new User("Hakimm", "Mlikii", "kimoo", "123456",new Date(), 2);
		User u3 = new User("Hakimmm", "Mlikiii", "kimooo", "123456",new Date(), 3);
		
		userBusines.createUser(u1);
		userBusines.createUser(u2);
		userBusines.createUser(u3);
		
	}
	

}

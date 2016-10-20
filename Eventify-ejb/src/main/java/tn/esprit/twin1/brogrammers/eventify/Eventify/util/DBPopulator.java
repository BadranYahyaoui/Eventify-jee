package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AttributBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Attribut;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventCategory;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventState;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventType;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.QuestionCategory;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.QuestionType;

@Singleton
@Startup
public class DBPopulator {

	@EJB
	UserBusinessLocal userBusines;

	@EJB
	OrganizationBusinessLocal organizationBusiness;

	
	@EJB
	EventBusinessLocal eventBusiness;
	
	@EJB
	WishlistBusinessLocal wishlistBusiness;
	
	@EJB
	QuestionBusinessLocal questionBusinessLocal;
	
	@EJB
	AttributBusinessLocal attributBusiness;
	
	public DBPopulator() {
	}

	@PostConstruct
	public void init() {

			
		User u1 = new User("Hakim", "Mliki", "kimo", "hakim.mliki@esprit.tn", "123456", new Date(), 1);
		User u2 = new User("Hakimm", "Mlikii", "kimoo", "hakim.mliki02@esprit.tn", "123456", new Date(), 2);
		User u3 = new User("Hakimmm", "Mlikiii", "kimooo", "hakim.mliki03@esprit.tn", "123456", new Date(), 3);

		userBusines.createUser(u1);
		userBusines.createUser(u2);
		userBusines.createUser(u3);
		


		Organization o1 = new Organization("TravelToDo","Fictif",new Date());
		Organization o2 = new Organization("MySecondOrganization","Physique",new Date());
		o1.setUser(u1);
		o2.setUser(u2);
		organizationBusiness.create(o1);
		organizationBusiness.create(o2);
		
		Event e1 = new Event("Sa7tek bin Ydina", "Health for everyone",new Date(), new Date(), 12, 9, 1000, EventType.Conference, EventCategory.Health, 10, new Date(),"FbLink","TwitterLink",EventState.UNPUBLISHED);
		e1.setOrganization(o1);
		Event e2 = new Event("Angular Course From Scratch", "Angular Course ",new Date(), new Date(), 12, 9, 1000, EventType.Class_Workshop, EventCategory.Science_Technology, 25, new Date(),"FbLink","TwitterLink",EventState.UNPUBLISHED);
		e2.setOrganization(o2);

		eventBusiness.create(e1);
		eventBusiness.create(e2);
		
		
		Question q1 = new Question("Combien d'enfants avez-vous ? ", QuestionType.Short_Anwser, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q1.setEvent(e1);
		questionBusinessLocal.createQuestion(q1);

		Question q2 = new Question("Cava ? ", QuestionType.Short_Anwser, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q2.setEvent(e1);
		questionBusinessLocal.createQuestion(q2);

		Question q3 = new Question("Combien de voitures avez vous ? ", QuestionType.Short_Anwser, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q3.setEvent(e2);
		questionBusinessLocal.createQuestion(q3);

		Attribut a1= new Attribut("hamdoulah", false, q1);
		attributBusiness.createAttribut(a1);

		Attribut a2= new Attribut("7al 7it", false, q1);
		attributBusiness.createAttribut(a2);

		Attribut a3= new Attribut("Labeess", false, q2);
		attributBusiness.createAttribut(a3);

		//Wishlist w1 = new Wishlist(new Date(),u1,e1);
	//	wishlistBusiness.addEventToWishlist(w1);
		
		
		

	}
		

}

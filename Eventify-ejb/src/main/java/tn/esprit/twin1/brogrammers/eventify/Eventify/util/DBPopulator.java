package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AttributBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CategoryBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Answer;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AnswerPK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Attribut;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Category;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.WishlistPK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventCategory;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventState;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventType;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.OrganizationType;
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
	
	@EJB
	CategoryBusinessLocal categoryBusiness;
	
	
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
		
		Category category = new Category(EventCategory.Business.toString()); 
		Category category1 = new Category(EventCategory.Politics.toString()); 
		Category category2 = new Category(EventCategory.Science_Technology.toString()); 
		categoryBusiness.addCategory(category);
		categoryBusiness.addCategory(category1);
		categoryBusiness.addCategory(category2);


		Organization o1 = new Organization("TravelToDo",OrganizationType.MORALE,new Date());
		Organization o2 = new Organization("MySecondOrganization",OrganizationType.PHYSIQUE,new Date());
		o1.setUser(u1);
		o2.setUser(u2);
		organizationBusiness.create(o1);
		organizationBusiness.create(o2);
		
		Event e1 = new Event("Sa7tek bin Ydina", "Health for everyone",new Date(), new Date(), 12, 9, 1000, EventType.Conference, category, 10, new Date(),"FbLink","TwitterLink",EventState.UNPUBLISHED);
		e1.setOrganization(o1);
		Event e2 = new Event("Angular Course From Scratch", "Angular Course ",new Date(), new Date(), 12, 9, 1000, EventType.Class_Workshop, category1, 25, new Date(),"FbLink","TwitterLink",EventState.UNPUBLISHED);
		e2.setOrganization(o2);

		eventBusiness.create(e1);
		eventBusiness.create(e2);
		
		
		Question q1 = new Question("Combien d'enfants avez-vous ? ", QuestionType.CheckBox, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q1.setEvent(e1);
		questionBusinessLocal.createQuestion(q1);

		Question q2 = new Question("Cava ? ", QuestionType.RadioBox, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q2.setEvent(e1);
		questionBusinessLocal.createQuestion(q2);

		Question q3 = new Question("Combien de voitures avez vous ? ", QuestionType.Short_Anwser, QuestionCategory.RegistrationForm, 1, new Date(), 1);
		q3.setEvent(e2);
		questionBusinessLocal.createQuestion(q3);

		Attribut a1= new Attribut("1", false, q1);
		attributBusiness.createAttribut(a1);

		Attribut a2= new Attribut("2", false, q1);
		attributBusiness.createAttribut(a2);

		Attribut a3= new Attribut("Tres Bien", false, q2);
		attributBusiness.createAttribut(a3);
		
		Attribut a4= new Attribut("Pas Mal", false, q2);
		attributBusiness.createAttribut(a4);

		/*
		AnswerPK answerPK1 =new AnswerPK();
		answerPK1.setIdAttribut(a1.getId());
		answerPK1.setIdUser(u1.getId());
		Answer answer1 = new Answer(answerPK1,u1,a1,"1",new Date());

		AnswerPK answerPK2 =new AnswerPK();
		answerPK2.setIdAttribut(a2.getId());
		answerPK2.setIdUser(u1.getId());
		Answer answer2 = new Answer(answerPK2,u1,a2,"2",new Date());

		
		
		WishlistPK pk = new WishlistPK();
		pk.setEventId(e1.getId());
		pk.setUserId(u1.getId());
		Wishlist w1 = new Wishlist(pk, new Date(), u1, e1);
		wishlistBusiness.addEventToWishlist(w1);

		WishlistPK pk1 = new WishlistPK();
		pk.setEventId(e2.getId());
		pk.setUserId(u1.getId());
		Wishlist w2 = new Wishlist(pk, new Date(), u1, e2);
		wishlistBusiness.addEventToWishlist(w2);
		*/

		
		
		

	}
		

}

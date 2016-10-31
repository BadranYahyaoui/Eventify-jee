package tn.esprit.twin1.brogrammers.eventify.Eventify.util;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.AttributBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.CategoryBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.EventBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.FavoriteBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.OrganizationBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RateBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.RefferUserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.UserBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.WishlistBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Answer;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.AnswerPK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Attribut;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Category;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Favorite;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.FavoritePK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organization;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Rate;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.RatePK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.ReferrelUser;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.ReferrelUserPK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.User;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Wishlist;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.WishlistPK;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventCategory;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventState;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.EventType;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.OrganizationType;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.QuestionCategory;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.QuestionType;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.enumeration.StateInvitation;

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
	
	@EJB
	RateBusinessLocal rateBusiness;
	
	@EJB
	FavoriteBusinessLocal favoriteBusiness;
	
	@EJB
	RefferUserBusinessLocal ReferrelUserBusiness;
	
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
		
		Category category = new Category(EventCategory.Health.toString()); 
		Category category1 = new Category(EventCategory.Science_Technology.toString()); 
		Category category2 = new Category(EventCategory.Business.toString()); 
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

		Event e3 = new Event("React From zero to hero", "React Course ",new Date(), new Date(), 12, 9, 50000, EventType.Class_Workshop, category1, 25, new Date(),"FbLink","TwitterLink",EventState.PUBLISHED);
		e3.setOrganization(o1);

		eventBusiness.create(e1);
		eventBusiness.create(e2);
		eventBusiness.create(e3);
		
		
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
		
		
		
		
		Rate r1 = new Rate(3,u1,e1);
		r1.setRatePK(new RatePK());
		r1.getRatePK().setIdUser(u1.getId());
		r1.getRatePK().setIdEvent(e1.getId());
		rateBusiness.createRate(r1);
		
		Rate r2 = new Rate(5,u2,e1);
		r2.setRatePK(new RatePK());
		r2.getRatePK().setIdUser(u2.getId());
		r2.getRatePK().setIdEvent(e1.getId());
		rateBusiness.createRate(r2);
		
		Rate r3 = new Rate(2,u3,e1);
		r3.setRatePK(new RatePK());
		r3.getRatePK().setIdUser(u3.getId());
		r3.getRatePK().setIdEvent(e1.getId());
		rateBusiness.createRate(r3);
		
		System.out.println("\n\n\n\n\n\n\n\nMoyenne Rate : "+rateBusiness.CalculRate(e1.getId())+"\n\n\n\n\n\n\n\n");
		
		ReferrelUser ref1 = new ReferrelUser(u1, u2, StateInvitation.CONFIRMED);
		ref1.setReferrelUserPK(new ReferrelUserPK());
		ref1.getReferrelUserPK().setIdUserReferral(u1.getId());
		ref1.getReferrelUserPK().setIdUserReferred(u2.getId());
		ReferrelUserBusiness.ChooseReferred(ref1);
		
		ReferrelUser ref2 = new ReferrelUser(u2, u3, StateInvitation.WAITING);
		ref2.setReferrelUserPK(new ReferrelUserPK());
		ref2.getReferrelUserPK().setIdUserReferral(u2.getId());
		ref2.getReferrelUserPK().setIdUserReferred(u3.getId());
		ReferrelUserBusiness.ChooseReferred(ref2);
		
		
		
		
		/*
		AnswerPK answerPK1 =new AnswerPK();
		answerPK1.setIdAttribut(a1.getId());
		answerPK1.setIdUser(u1.getId());
		Answer answer1 = new Answer(answerPK1,u1,a1,"1",new Date());

		AnswerPK answerPK2 =new AnswerPK();
		answerPK2.setIdAttribut(a2.getId());
		answerPK2.setIdUser(u1.getId());
		Answer answer2 = new Answer(answerPK2,u1,a2,"2",new Date());
		 */
		
		
		//Adding Wishlist Start
		
		Wishlist w1 = new Wishlist(new Date(), u1, e1);
		Wishlist w2 = new Wishlist(new Date(), u1, e2);
		w1.setWishlistPK(new WishlistPK());
		w2.setWishlistPK(new WishlistPK());
		
		w1.getWishlistPK().setEventId(e1.getId());
		w1.getWishlistPK().setUserId(u1.getId());

		w2.getWishlistPK().setEventId(e2.getId());
		w2.getWishlistPK().setUserId(u1.getId());

		wishlistBusiness.addEventToWishlist(w1);
		wishlistBusiness.addEventToWishlist(w2);
		
		//Adding Wishlist END


		//Adding Favorites Start
		
		Favorite f1 = new Favorite(2, u1, category);
		Favorite f2 = new Favorite(1, u1, category1);
		Favorite f3 = new Favorite(3, u1, category2);
		
		f1.setFavoritePK(new FavoritePK());
		f1.getFavoritePK().setCategoryId(category.getId());
		f1.getFavoritePK().setUserId(u1.getId());

		f2.setFavoritePK(new FavoritePK());
		f2.getFavoritePK().setCategoryId(category1.getId());
		f2.getFavoritePK().setUserId(u1.getId());

		f3.setFavoritePK(new FavoritePK());
		f3.getFavoritePK().setCategoryId(category2.getId());
		f3.getFavoritePK().setUserId(u1.getId());
		
		favoriteBusiness.addFavorite(f1);
		favoriteBusiness.addFavorite(f2);
		favoriteBusiness.addFavorite(f3);
		
		//Adding Favorites END


	}
		

}

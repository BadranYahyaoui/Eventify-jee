package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Questions;



/**
 * Session Bean implementation class QuestionBusiness
 */
@Stateless
public class QuestionBusiness implements QuestionBusinessRemote, QuestionBusinessLocal {

	
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public QuestionBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void createQuestion(Questions question) {

		entityManager.merge(question);
		
	}

	@Override
	public void updateQuestion(Questions question) {
		entityManager.merge(question);
		
	}

	@Override
	public void deleteQuestion(Questions question) {
		entityManager.remove(question);
		
	}

	@Override
	public Questions getQuestionById(int id) {
		return entityManager.find(Questions.class , id);
	}

    
    
    
    

}

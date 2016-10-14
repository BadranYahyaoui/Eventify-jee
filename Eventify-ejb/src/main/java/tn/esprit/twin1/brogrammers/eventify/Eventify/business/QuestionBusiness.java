package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.QuestionBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;



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
	public void createQuestion(Question question) {

		entityManager.merge(question);
		
	}

	@Override
	public boolean updateQuestion(Question question) {
		if(getQuestionById(question.getId())!=null){
			entityManager.merge(question);
			return true;
		}
		else
			return false;
		
		
	}

	@Override
	public boolean deleteQuestion(int id) {
		if(getQuestionById(id)!=null){
			entityManager.remove(id);
			return true;
		}
		else
			return false;
		
	}

	@Override
	public Question getQuestionById(int id) {
		return entityManager.find(Question.class , id);
	}

    
    
    
    

}

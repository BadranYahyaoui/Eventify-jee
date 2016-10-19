package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;


@Local
public interface QuestionBusinessLocal {
	
	public void createQuestion(Question question);
	public boolean updateQuestion(Question question);
	public boolean deleteQuestion(int id);
	public Question getQuestionById(int id);
		
	

}

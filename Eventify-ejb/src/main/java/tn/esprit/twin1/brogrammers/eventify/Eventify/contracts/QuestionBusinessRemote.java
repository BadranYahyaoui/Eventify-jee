package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Questions;

@Remote
public interface QuestionBusinessRemote {
	public void createQuestion(Questions question);
	public boolean updateQuestion(Questions question);
	public boolean deleteQuestion(int id);
	public Questions getQuestionById(int id);

}

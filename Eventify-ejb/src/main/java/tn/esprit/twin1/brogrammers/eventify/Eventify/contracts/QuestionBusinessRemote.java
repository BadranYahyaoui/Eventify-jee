package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Question;

@Remote
public interface QuestionBusinessRemote {
	public void createQuestion(Question question);
	public boolean updateQuestion(Question question);
	public boolean deleteQuestion(int id);
	public Question getQuestionById(int id);

}

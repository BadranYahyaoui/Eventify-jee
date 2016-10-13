package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Attributs
 *
 */
@Entity

public class Attribut implements Serializable {

	   
	
	private int id;
	private String attributValue;
	private static final long serialVersionUID = 1L;

	private List<Answer> answers;
	private Questions questions;
	

	public Attribut() {
		super();
	}
	
	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getAttributValue() {
		return this.attributValue;
	}

	public void setAttributValue(String attributValue) {
		this.attributValue = attributValue;
	}

	@OneToMany(mappedBy="attribut")
	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@ManyToOne(fetch=FetchType.LAZY)
	public Questions getQuestions() {
		return questions;
	}

	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
   
	
}

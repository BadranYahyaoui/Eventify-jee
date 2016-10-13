package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Questions
 *
 */
@Entity
public class Questions implements Serializable {

	   
	private int id;
	private String questionDescription;
	private String questionType;
	private String questionCategory;
	private boolean status;
	private Date questionDate;
	private int order;
	
	private static final long serialVersionUID = 1L;

	private Event event;
	
	private List<Attribut> attributs;

	
	public Questions() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}   
	public String getQuestionDescription() {
		return this.questionDescription;
	}

	public void setQuestionDescription(String questionDescription) {
		this.questionDescription = questionDescription;
	}   
	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}   
	public String getQuestionCategory() {
		return this.questionCategory;
	}

	public void setQuestionCategory(String questionCategory) {
		this.questionCategory = questionCategory;
	}   
	public boolean getStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}   
	public Date getQuestionDate() {
		return this.questionDate;
	}

	public void setQuestionDate(Date questionDate) {
		this.questionDate = questionDate;
	}   
	public int getOrder() {
		return this.order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	/* Foreign Key Start */
	
	@ManyToOne(fetch=FetchType.LAZY)
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	
	//Assocation With Attributs
	
	@OneToMany(mappedBy="questions")
	public List<Attribut> getAttributs() {
		return attributs;
	}

	public void setAttributs(List<Attribut> attributs) {
		this.attributs = attributs;
	}
	
	
	
	/* Foreign Key End  */
   
}

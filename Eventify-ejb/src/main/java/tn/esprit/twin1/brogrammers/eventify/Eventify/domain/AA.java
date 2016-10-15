package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: AA
 *
 */
@Entity

public class AA implements Serializable {

	@Id
	private int idAA;
	private String nameAA;

	@ManyToOne(fetch = FetchType.LAZY)
	private A a;

	private static final long serialVersionUID = 1L;

	public AA() {
		super();
	}

	/*To ADD*/
	public AA(int idAA, String nameAA, A a) {
		super();
		this.idAA = idAA;
		this.nameAA = nameAA;
		this.a = a;

	}

	public int getIdAA() {
		return this.idAA;
	}

	public void setIdAA(int idAA) {
		this.idAA = idAA;
	}

	public String getNameAA() {
		return this.nameAA;
	}

	public void setNameAA(String nameAA) {
		this.nameAA = nameAA;
	}

	public A getA() {
		return a;
	}

	public void setA(A a) {
		this.a = a;
	}

}

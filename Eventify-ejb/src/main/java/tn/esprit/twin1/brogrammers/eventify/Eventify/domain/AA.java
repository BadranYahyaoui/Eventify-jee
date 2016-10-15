package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.ejb.EJB;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: AA
 *
 */
@Entity

public class AA implements Serializable {

	   
	@Id
	private int idAA;
	private String nameAA;
	
	@ManyToOne(fetch=FetchType.LAZY)
	private A a;

	
	private static final long serialVersionUID = 1L;

	public AA() {
		super();
	}   
	
	
	
	public AA (int idAA, String nameAA , A a) {
		super();
		this.idAA = idAA;
		this.nameAA = nameAA;
		this.a= a;
		
	}
	
	

	









	public AA(int idAA, String nameAA) {
		super();
		this.idAA = idAA;
		this.nameAA = nameAA;
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

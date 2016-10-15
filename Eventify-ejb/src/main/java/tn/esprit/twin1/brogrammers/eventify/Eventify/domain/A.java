package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity
public class A implements Serializable {

	   
	@Id
	private int idA;
	private String nameA;
	@OneToMany(mappedBy="a" , fetch=FetchType.LAZY)
	private List<AA> aas;
	
	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}  
	
	
	
	public A(int idA) {
		super();
		this.idA = idA;
	}



	public A(int idA, String nameA) {
		super();
		this.idA = idA;
		this.nameA = nameA;
	}

	


	public A(int idA, String nameA, List<AA> aas) {
		super();
		this.idA = idA;
		this.nameA = nameA;
		this.aas = aas;
	}
	
	




	
	public A(List<AA> aas) {
		super();
		this.aas = aas;
	}



	public void linkAASToThisA(List<AA> aas) {
		this.aas = aas;
		for (AA aaa : aas) {
			aaa.setA(this);
		}
	}



	public int getIdA() {
		return this.idA;
	}

	public void setIdA(int idA) {
		this.idA = idA;
	}   
	public String getNameA() {
		return this.nameA;
	}

	public void setNameA(String nameA) {
		this.nameA = nameA;
	}
	public List<AA> getAas() {
		return aas;
	}
	public void setAas(List<AA> aas) {
		this.aas = aas;
	}
	
	
   
}

package tn.esprit.twin1.brogrammers.eventify.Eventify.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Entity implementation class for Entity: A
 *
 */
@Entity
public class A implements Serializable {

	@Id
	private int idA;
	private String nameA;
	@OneToMany(mappedBy = "a", fetch = FetchType.LAZY)
	private List<AA> aas;

	private static final long serialVersionUID = 1L;

	public A() {
		super();
	}
	/*TO ADD*/
	public A(int idA, String nameA) {
		super();
		this.idA = idA;
		this.nameA = nameA;
	}


	/*public void linkAASToThisA(List<AA> aas) {
		this.aas = aas;
		for (AA aaa : aas) {
			aaa.setA(this);
		}
	}*/

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

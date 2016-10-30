package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import javax.ejb.Local;
import javax.ejb.Remote;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Category;

@Local
public interface CategoryBusinessLocal {
	
	public void addCategory(Category category);
	public void deleteCategory(int id);
	public Category findById(int id);

}

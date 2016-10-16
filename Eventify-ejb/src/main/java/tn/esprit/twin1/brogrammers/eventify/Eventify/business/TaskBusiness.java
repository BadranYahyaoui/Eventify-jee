package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.Iterator;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.TaskBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.TaskBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Event;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Media;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Organizer;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Task;;

/**
 * Session Bean implementation class TaskBusiness
 */
@Stateless
public class TaskBusiness implements TaskBusinessRemote, TaskBusinessLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName = "Eventify-ejb")
	EntityManager entityManager;
	
    public TaskBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void updateTask(Task task) {
		
		entityManager.merge(task);
		
		
	}

	@Override
	public void deleteTask(Task task) {
		
		
	}

	@Override
	public Task findTaskByID(int id) {
		
		return entityManager.find(Task.class, id);
	}

	@Override
	public List<Task> getAllTasksByID(int idEvent) {
		Query query = entityManager
	    		.createQuery("SELECT t FROM Task t WHERE t.event.id = :idEvent")
	    		.setParameter("idEvent", idEvent);
	    return (List<Task>) query.getResultList();
		
	}

	@Override
	public List<Task> GetTasksByOrganizer(int idOrganizer) {
		Query query = entityManager
	    		.createQuery("SELECT o.task FROM Organizer o WHERE o.id = :idOrganizer")
	    		.setParameter("idOrganizer", idOrganizer);
		return (List<Task>) query.getResultList();
	}

	@Override
	public void cancelTask(Task task, int idOrganizer) {
		Task t=entityManager.find(Task.class,task.getId());
       // entityManager.getTransaction().begin();
		List<Organizer> l =t.getOrganizers();
        Iterator<Organizer> it = l.iterator();
        while (it.hasNext()) {
          Organizer organizer = it.next();
          if (organizer.getTask().equals(task)) {
            it.remove();
          }
        }
          entityManager.getTransaction().begin();
          t.setOrganizers(l);
          entityManager.getTransaction().commit();
          
          
        
		
	}

	@Override
	public void assignTaskToOrgnizer(int idOrgnizer, int Taskid) {
		Task t=entityManager.find(Task.class,Taskid);
		Organizer o=entityManager.find(Organizer.class,idOrgnizer);
		List<Organizer> l =t.getOrganizers();
		l.add(o);
		entityManager.getTransaction().begin();
        t.setOrganizers(l);
        entityManager.getTransaction().commit();
		
		
	}

	@Override
	public void taskStatusCompleted(int idOrgnizer, int Taskid) {
		Organizer o=entityManager.find(Organizer.class,idOrgnizer);
		Task t =o.getTask();
		t.setTaskStatus(2);
		entityManager.getTransaction().begin();
        o.setTask(t);
        entityManager.getTransaction().commit();
	}

	@Override
	public int getTaskStatus(int taskID) {
		Task t=entityManager.find(Task.class,taskID);
		
		return t.getTaskStatus();
	}

	@Override
	public void createTask(Task task) {
		entityManager.persist(task);
		
	}

}

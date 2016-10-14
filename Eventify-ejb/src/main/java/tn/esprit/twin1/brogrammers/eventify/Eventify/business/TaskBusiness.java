package tn.esprit.twin1.brogrammers.eventify.Eventify.business;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.TaskBusinessLocal;
import tn.esprit.twin1.brogrammers.eventify.Eventify.contracts.TaskBusinessRemote;
import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Task;;

/**
 * Session Bean implementation class TaskBusiness
 */
@Stateless
public class TaskBusiness implements TaskBusinessRemote, TaskBusinessLocal {

    /**
     * Default constructor. 
     */
    public TaskBusiness() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void updateTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteTask(Task task) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Task findTaskByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getAllTasksByID(int idEvent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> GetTasksByOrganizer(int idOrganizer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean cancelTask(Task task, int idOrganizer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void assignTaskToOrgnizer(int idOrgnizer, int Taskid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskStatusCompleted(int idOrgnizer, int Taskid) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getTaskStatus(int taskID) {
		// TODO Auto-generated method stub
		return 0;
	}

}

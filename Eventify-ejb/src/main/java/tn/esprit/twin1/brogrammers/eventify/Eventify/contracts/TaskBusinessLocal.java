package tn.esprit.twin1.brogrammers.eventify.Eventify.contracts;

import java.util.List;

import javax.ejb.Local;

import tn.esprit.twin1.brogrammers.eventify.Eventify.domain.Task;

@Local
public interface TaskBusinessLocal {
	
	
	public void  createTask(Task task);
	//update task
	   public void updateTask(Task task);
	   
	   //DeleteTask
	   public void deleteTask(Task task);
	 
	//get a task by id
	public Task findTaskByID(int id);
	
	//get all the Tasks Related To an event
	public List<Task>getAllTasksByID(int idEvent);
	   
	//get all the tasks Assigned to an oganizer 
	public  List<Task>GetTasksByOrganizer(int idOrganizer);
		
	 //cancel task to an orgnizer
	public void cancelTask(Task task,int idOrganizer);
	
	
	
	//asssign task to an oganizer
	public void assignTaskToOrgnizer(int idOrgnizer,int Taskid);
	
	 //when Orgnizer complete Task
		
	public void taskStatusCompleted(int idOrgnizer,int Taskid);
	
	
	//get a task status --Completed --not completed --Working On
	public int getTaskStatus(int taskID);


}

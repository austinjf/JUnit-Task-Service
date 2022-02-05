package main;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class that adds, deletes, and updates instances of Task objects within
 * an ArrayList of Task objects. 
 * 
 * @author Austin Fuchs - CS 320 Milestone 2
 * @since 2022-01-30
 *
 */

public class TaskService {

	// Memory for Task objects
	ArrayList<Task> tasks = new ArrayList<Task>();
	Iterator<Task> tasksIterator;

	// FIXME: add constructor?
	
	/**
	 * Adds a Task object to the ArrayList of Task objects while
	 * ensuring that the id of the new Task object is unique within
	 * the ArrayList. If the id is not unique, an exception is thrown.
	 * 
	 * @param task	The Task object to be added.
	 */
	public void addTask(Task task) {
		
		// initialize the iterator
		tasksIterator = tasks.iterator();
		
		// iterate over the ArrayList of Tasks
		while (tasksIterator.hasNext()) {
			
			// check to ensure new Task ID is unique, if not throw exception
			if (tasksIterator.next().getId().equals(task.getId()))
				throw new IllegalArgumentException("New Task ID is not unique");
		}
		
		// new Task ID is unique, add task to ArrayList
		tasks.add(task);
	}
	
	/**
	 * Removes the Task object that matches the param id from the ArrayList of
	 * Task objects. If the id is not found, an exception is thrown.
	 * 
	 * @param id	The id of the Task object to be removed
	 */
	public void deleteTask(String id) {
		
		// initialize the iterator
		tasksIterator = tasks.iterator();
		
		// iterate over the ArrayList of Tasks
		while (tasksIterator.hasNext()) {
			
			// check to ensure Task object with id exists
			if (tasksIterator.next().getId().equals(id)) {
				
				// task with id exists, remove task and exit method
				tasksIterator.remove();
				return;
			}
		}
		
		// iterated over ArrayList of tasks and id not found
		throw new IllegalArgumentException("Task ID entered does not exist.");
	}
	
	/**
	 * Updates the name of the Task object within the ArrayList of
	 * Task objects that has the same id.
	 * 
	 * @param id			The id of the Task to be updated.
	 * @param newName		The new name to be updated.
	 */
	public void updateTaskName(String id, String newName) {
		
		// initialize iterator and index variable
		int i = 0;
		tasksIterator = tasks.iterator();
		
		while (tasksIterator.hasNext()) {
			
			// check Task object with id exists
			if (tasksIterator.next().getId().equals(id)) {
				
				// task exists, update first name
				tasks.get(i).setName(newName);
				return;
			}
			
			i++; // increment index for next loop iteration
		}
		
		// iterated over ArrayList of Tasks and id not found
		throw new IllegalArgumentException("Task ID entered does not exist.");
	}
	
	/**
	 * Updates the name of the Task object within the ArrayList of
	 * Task objects that has the same id.
	 * 
	 * @param id				The id of the Task to be updated.
	 * @param newDescription	The new name to be updated.
	 */
	public void updateTaskDescription(String id, String newDescription) {
		
		// initialize iterator and index variable
		int i = 0;
		tasksIterator = tasks.iterator();
		
		while (tasksIterator.hasNext()) {
			
			// check Task object with id exists
			if (tasksIterator.next().getId().equals(id)) {
				
				// task exists, update description
				tasks.get(i).setDescription(newDescription);
				return;
			}
			
			i++; // increment index for next loop iteration
		}
		
		// iterated over ArrayList of Tasks and id not found
		throw new IllegalArgumentException("Task ID entered does not exist.");
	}
}

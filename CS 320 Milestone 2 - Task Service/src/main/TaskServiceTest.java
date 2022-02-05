package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskServiceTest {

	// test variables
	String id = "0123456789"; // 10 characters
	String name = "TwentyCharacterName!"; // 20 characters
	String description = "A description with exactly 50 characters, precise!"; 
	
	@Test
	void testTaskServiceAddTask() {
		
		// initialize task service and add task
		TaskService service = new TaskService();
		Task task = new Task(id, name, description);
		
		// test task can be added to task service
		service.addTask(task);
		assertTrue(service.tasks.get(0).equals(task));
		
		// test adding task with non-unique id throws exception
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.addTask(task);
		});
	}
	
	@Test
	void testTaskServiceDeleteTask() {
		
		// initialize task service and add task
		TaskService service = new TaskService();
		Task task = new Task(id, name, description);
		Task anotherTask = new Task("123", name, description);
		service.addTask(task);
		service.addTask(anotherTask);
		
		// test task can be deleted from service
		service.deleteTask(id);
		
		// test exception thrown for id not found
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			service.deleteTask(id);
		});
	}
	
	@Test
	void testTaskServiceUpdateName() {
		
		// initialize task service and add task
		TaskService service = new TaskService();
		Task task = new Task(id, name, description);
		service.addTask(task);
		
		// test task can update name
		service.updateTaskName(id, "Finish Project");
		
		// test exception thrown for id not found
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskName("123", name);
		});
	}
	
	@Test
	void testTaskServiceUpdateDescription() {
		
		// initialize task service and add task
		TaskService service = new TaskService();
		Task task = new Task(id, name, description);
		service.addTask(task);
		
		// test task can update description
		service.updateTaskDescription(id, "Top priority. This project is worth a lot.");
		
		// test exception thrown for id not found
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			service.updateTaskDescription("123", name);
		});
	}

}

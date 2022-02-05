package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskTest {

	// test variables
	String id = "0123456789"; // 10 characters
	String name = "TwentyCharacterName!"; // 20 characters
	String description = "A description with exactly 50 characters, precise!"; 
	
	@Test
	void testTaskClass() {
		Task task = new Task(id, name, description);
		
		assertTrue(task.getId().equals(id));
		assertTrue(task.getName().equals(name));
		assertTrue(task.getDescription().equals(description));
	}
	
	@Test
	void testTaskClassIdException() {
		String tooLongId = "01234567890"; // id with 11 characters
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(tooLongId, name, description);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, name, description);
		});
	}

	@Test
	void testTaskClassNameException() {
		String tooLongName = "TwentyOneCharacters!!"; // name with 21 characters
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, tooLongName, description);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, null, description);
		});
	}
	
	@Test
	void testTaskClassDescriptionException() {
		String tooLongDescription = "A description with 51 unwanted characters. Sad.  :("; // name with 21 characters
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, name, tooLongDescription);
		});
		
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Task(id, name, null);
		});
	}
	
	@Test
	void testTaskNameSetter() {
		Task task = new Task(id, name, description);
		String newName = "New Name";
		
		// test new name set
		task.setName(newName);
		assertTrue(task.getName().equals(newName));
		
		// test exception thrown for long name
		String tooLongName = "TwentyOneCharacters!!"; // name with 21 characters
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(tooLongName);
		});
		
		// test exception thrown for null name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setName(null);
		});
	}
	
	@Test
	void testTakeDescriptionSetter() {
		Task task = new Task(id, name, description);
		String newDescription = "New Description";
		
		// test new description set
		task.setDescription(newDescription);
		assertTrue(task.getDescription().equals(newDescription));
		
		// test exception thrown for long description
		String tooLongDescription = "A description with 51 unwanted characters. Sad.  :(";
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(tooLongDescription);
		});
		
		// test exception thrown for null name
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			task.setDescription(null);
		});
	}


}

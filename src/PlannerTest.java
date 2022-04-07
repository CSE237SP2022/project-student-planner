import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class PlannerTest {

	private static Scanner scanner;
	private HashMap<Class, List<Todo>> listOfClassesAndTodos;
	private Planner planner = new Planner(scanner);
	
	@BeforeEach
	void setup() {
		//Planner planner = new Planner(scanner); //setup
	}
	
	@Test
	void testgetUserInput() {
		String input = planner.getUserInput();
		assertTrue("A".equals(input));
	}
	
	@Test
	void testGetNumberOfTodos() {
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "1");
		
		List<Todo> englishTodos = new List<Todo>();
		
		planner.listOfClassesAndTodos.put(english, englishTodos);
		
		int numberOfTodos = listOfClassesAndTodos.getNumberOfTodos();
		
		assertTrue(numberOfTodos == 2);
	}
	
	@Test
	void testAddTodo() {		
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "1");
		
		List<Todo> englishTodos = new List<Todo>();
		
		planner.listOfClassesAndTodos.put(english, englishTodos);
		
		Todo newTodo = new Todo("Write essay", "April 28th", "2");
	
		listOfClassesAndTodos.get(english).addTodo(newTodo);
		int numberOfTodos = listOfClassesAndTodos.getNumberOfTodos();
	
		assertTrue(numberOfTodos == 3);
	}
	
	

}

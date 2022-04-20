import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
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
	void testGetNumberOfTodosZeroTodos() {
		Class english = new Class("English");
		List<Todo> todos = new ArrayList<Todo>();
		
		planner.listOfClassesAndTodos.put(english, todos);
		
		int numberOfTodos = planner.getNumberOfTodos();
		
		assertTrue(numberOfTodos == 0);
	}
	
	@Test
	void testGetNumberOfTodos() {
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "1");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		
		planner.listOfClassesAndTodos.put(english, englishTodos);
		
		//Note @ Sophia for the red line to go away for me  planner.getNumberOfTodos(); worked
		int numberOfTodos = planner.getNumberOfTodos();
		
		assertTrue(numberOfTodos == 2);
	}
	
	@Test
	void testgetNumberOfClassesZeroClasses() {
		int numberOfClasses = planner.getNumberOfClasses();
		
		assertTrue(numberOfClasses == 0);
	}
	
	@Test 
	void testgetNumberOfClasses() {
		Class biology = new Class("Biology");
		Class chemistry = new Class("Chemistry");
		planner.listOfClassesAndTodos.put(biology, null);
		planner.listOfClassesAndTodos.put(chemistry, null);
		
		int numberOfClasses = planner.getNumberOfClasses();
		
		assertTrue(numberOfClasses == 2);
	}
	
	@Test
	void testAddTodoFirstTodo() {
		String englishString = "English";
		Class english = new Class("English");
		
		List<Todo> englishTodos = new ArrayList<Todo>();

		planner.listOfClassesAndTodos.put(english, englishTodos);
		
		Todo newTodo = new Todo("Write essay", "April 28th", "2");
	
		planner.addTodo(newTodo, englishString);
		int numberOfTodos = planner.getNumberOfTodos();
	
		assertTrue(numberOfTodos == 1);
	}
	
	@Test
	void testAddTodo() {	
		String englishString = "English";
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "1");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);

		planner.listOfClassesAndTodos.put(english, englishTodos);
		
		Todo newTodo = new Todo("Write essay", "April 28th", "2");
	
		planner.addTodo(newTodo, englishString);
		int numberOfTodos = planner.getNumberOfTodos();
	
		assertTrue(numberOfTodos == 3);
	}
	
	@Test
	void testAddClassFirstClass() {
		Class newClass = new Class("Spanish");
		String newClassName = newClass.getClassName();
		planner.addClass(newClassName);
		
		int numberOfClasses = planner.getNumberOfClasses();
		assertTrue(numberOfClasses == 1);
	}
	
	@Test 
	void testAddClass() {
		Class english = new Class("English");
		Class math = new Class("Math");
		planner.listOfClassesAndTodos.put(english, null);
		planner.listOfClassesAndTodos.put(math, null);
		
		Class newClass = new Class("Spanish");
		String newClassName = newClass.getClassName();
		planner.addClass(newClassName);
		
		int numberOfClasses = planner.getNumberOfClasses();
		assertTrue(numberOfClasses == 3);
	}
	
	@Test
	void testDeleteTodo() {
		String englishString = "English";
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "1");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		planner.listOfClassesAndTodos.put(english, englishTodos);
		planner.deleteTodo("English", "todo1");
		int numberOfTodos = planner.getNumberOfTodos();
		
		assertTrue(numberOfTodos == 1);
	}
	
	@Test
	void testDeleteNoTodos() { //empty list
		planner.deleteTodo("English", "todo1");
		int numberOfTodos = planner.getNumberOfTodos();
		assertTrue(numberOfTodos == 0);
	}
	
	

}

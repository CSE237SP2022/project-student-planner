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
	
	@Test
	void testOrderByPriorityInOrder() {
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "1");
		Todo todo2 = new Todo("todo2", "January", "2");
		Todo todo3 = new Todo("todo3", "January", "3");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		englishTodos.add(todo3);
		planner.listOfClassesAndTodos.put(english, englishTodos);
		List<Todo> ordered = planner.orderByPriority(english);
		
		assertTrue(ordered.get(0) == todo1);
		assertTrue(ordered.get(1) == todo2);
		assertTrue(ordered.get(2) == todo3);
	}
	
	@Test
	void testOrderByPriorityBackward() {
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "3");
		Todo todo2 = new Todo("todo2", "January", "2");
		Todo todo3 = new Todo("todo3", "January", "1");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		englishTodos.add(todo3);
		planner.listOfClassesAndTodos.put(english, englishTodos);
		List<Todo> ordered = planner.orderByPriority(english);
		
		assertTrue(ordered.get(0) == todo3);
		assertTrue(ordered.get(1) == todo2);
		assertTrue(ordered.get(2) == todo1);
	}
	
	@Test
	void testOrderByPriorityMixed() { //empty list
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "2");
		Todo todo2 = new Todo("todo2", "January", "3");
		Todo todo3 = new Todo("todo3", "January", "1");
		Todo todo4 = new Todo("todo4", "January", "2");
		Todo todo5 = new Todo("todo5", "January", "3");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		englishTodos.add(todo3);
		englishTodos.add(todo4);
		englishTodos.add(todo5);
		planner.listOfClassesAndTodos.put(english, englishTodos);
		List<Todo> ordered = planner.orderByPriority(english);
		
		assertTrue(ordered.get(0) == todo3);
		assertTrue(ordered.get(1) == todo1 || ordered.get(1) == todo4);
		assertTrue(ordered.get(2) == todo1 || ordered.get(2) == todo4);
		assertTrue(ordered.get(3) == todo2 || ordered.get(3) == todo5);
		assertTrue(ordered.get(4) == todo2 || ordered.get(4) == todo5);
	}
	
	@Test
	void testTodosOfSpecifiedPriority() {
		Class english = new Class("English");
		Todo todo1 = new Todo("todo1", "January", "3");
		Todo todo2 = new Todo("todo2", "January", "3");
		Todo todo3 = new Todo("todo3", "January", "1");
		
		List<Todo> englishTodos = new ArrayList<Todo>();
		englishTodos.add(todo1);
		englishTodos.add(todo2);
		englishTodos.add(todo3);
		planner.listOfClassesAndTodos.put(english, englishTodos);
		List<Todo> priority1 = planner.todosOfSpecifiedPriority(english, "1");
		List<Todo> priority2 = planner.todosOfSpecifiedPriority(english, "2");
		List<Todo> priority3 = planner.todosOfSpecifiedPriority(english, "3");
		
		List<Todo> one = new ArrayList<Todo>();
		one.add(todo3);
		List<Todo> three = new ArrayList<Todo>();
		three.add(todo1);
		three.add(todo2);
		
		assertTrue(priority1 == one);
		assertTrue(priority2 == null);
		assertTrue(priority3 == three);
	}

}

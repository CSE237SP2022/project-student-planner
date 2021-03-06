import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * An object that represents student's academic planner
 * Contains a student's classes and the todo items associated with each class
 * @author Sophia Rosset
 * 
 */
public class Planner {

	private static Scanner scanner;
	HashMap<Class, List<Todo>> listOfClassesAndTodos;
	List<String> courseList;
	
	
	public Planner(Scanner scanner) {
		this.scanner = new Scanner(System.in);
		this.listOfClassesAndTodos = new HashMap<Class, List<Todo>>();
		this.courseList = new ArrayList<String>();
	}
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		Planner planner = new Planner(scanner);
		
		planner.printTodos(); //automatically prints current list (should start empty)
		
		planner.printInstructions();
		
		String input = getUserInput();
		userCommand(input, planner);
		
	}
	
	public static void userCommand(String input, Planner planner) {
		while(!input.equals("X")) {
			if(input.equals("L")) {
				planner.printTodos();
			}
			else if(input.equals("C")) {
				//TODO: fill in for when a class is added
				planner.getInputClass();
				
			}
			else if(input.equals("T")) {
				//TODO: fill in for when a todo item is added
				planner.getInputTodo();
			}
			else if (input.equals("P")) {
				planner.printByPriority();
			}
			else if(input.equals("D")){
				planner.deleteInputTodo();
			}
			else if(input.equals("O")){
				planner.completeInputTodo();
			}
			else {
				System.out.println("That is an invalid command.");
			}
			planner.printInstructions();
			input = getUserInput();
		}
	}
	
	public static String getUserInput() {
		String input = scanner.nextLine(); // read user input
		return input;
	}
	
	public void printInstructions() {
		System.out.println();
		// lists options of actions		
		System.out.println("_______________________");
		System.out.println("To add a class, enter C");
		System.out.println("To add a todo, enter T");
		System.out.println("To view your current list of classes and todos, enter L");
		System.out.println("To view todos of a certain priority, enter P");
		System.out.println("To delete a todo, enter D");
		System.out.println("To check off a todo, enter O");
		System.out.println("To exit your planner, enter X");
	}
	
	public void printTodos() {
		System.out.println("Your current classes and todos:");
		
		if(this.listOfClassesAndTodos != null) {
			listOfClassesAndTodos.forEach((key, value) -> {
				String courseName = key.getClassName();
				List<Todo> orderedTodos = orderByPriority(key);
				System.out.println(courseName + ":");
				
				orderedTodos.forEach((t) -> {
					if (!t.getIsComplete()) {
						System.out.println(t.getName()+" ("+t.getPriority()+")");
					}
				});
				
				System.out.println("Completed:");
				orderedTodos.forEach((t) -> {
					if (t.getIsComplete()) {
						System.out.println(t.getName()+" ("+t.getPriority()+")");
					}
				});
				System.out.println();
			});
		}
		else {
			System.out.println("You currently have no classes or todos.");
		}
	}
	
	public void printByPriority() {
		System.out.println("What priority todos would you like to view?");
		String priority = getUserInput();
		System.out.println("Your current classes and todos:");
		if(this.listOfClassesAndTodos != null) {
			listOfClassesAndTodos.forEach((key, value) -> {
				String course = key.getClassName();
				List<Todo> todosByPriority = todosOfSpecifiedPriority(key, priority);
				System.out.println(course + ":");
				todosByPriority.forEach((t) -> {
					System.out.println(t.getName()+" ("+t.getPriority()+")");
				});
				System.out.println();
			});
			
		}
		else {
			System.out.println("You currently have no classes or todos.");
		}
	}
	
	public void getInputClass() {
		System.out.println("Enter the name of the course you want to add:");
		String courseName = getUserInput();
		
		addClass(courseName);
	}
	
	public void addClass(String courseName) {
		Class course = new Class(courseName);
		listOfClassesAndTodos.put(course, null);
		courseList.add(course.getClassName());
	}
	
	public void getInputTodo() {
		System.out.println("Enter the name of the class this todo falls under:");
		String className = getUserInput();
		
		if (!courseList.contains(className)) {
			System.out.println("This class does not exist. Enter 'A' to add this class, or 'R' to return to the main menu.");
			String input = getUserInput();
			if(input.equals("A")) {
				System.out.println("Enter the name of the course you want to add");
				Class course = new Class(className);
				listOfClassesAndTodos.put(course, null);
				courseList.add(course.getClassName());
			} else {
				//TODO: implement a mainMenu() method
				return;
			}
		}
		
		System.out.println("Enter the name of the todo you would like to add:");
		String todoName = getUserInput();
		System.out.println("Enter the due date of the todo:");
		String todoDate = getUserInput();
		System.out.println("Enter the todo's priority level (between 1-3):");
		String todoLevel = getUserInput();
		
		Todo todo = new Todo(todoName, todoDate, todoLevel, false);
		addTodo(todo, className);
		
	}
	
	public void addTodo(Todo todo, String className) {
		// add todo to the class
		listOfClassesAndTodos.forEach((key, value) -> {
			if(key.getClassName().equals(className)) {
				List<Todo> courseTodos = listOfClassesAndTodos.get(key);
				if(courseTodos == null) {
					courseTodos = new ArrayList<Todo>();
					courseTodos.add(todo);
					listOfClassesAndTodos.put(key, courseTodos);
				}
				else {
					listOfClassesAndTodos.get(key).add(todo);
				}
			}
		});
	}
	
	public int getNumberOfTodos() {
		int numberOfTodos = 0;
		for (Class c: listOfClassesAndTodos.keySet()) {
			numberOfTodos += listOfClassesAndTodos.get(c).size();
		}
		return numberOfTodos;
	}
	
	public int getNumberOfClasses() {
		int numberOfClasses = listOfClassesAndTodos.size();
		return numberOfClasses;
	}
	
	public void deleteInputTodo() {
		System.out.println("Enter the name of the class this todo falls under:");
		String classNameInput = getUserInput();
		//Class course = new Class(className);

		System.out.println("Enter the name of the todo you would like to delete:");
		String todoNameInput = getUserInput();
		
		deleteTodo(classNameInput, todoNameInput);
	} 
	
	public void deleteTodo(String classNameInput, String todoNameInput) {	
		List<Todo> todosAfterRemoval = new ArrayList<Todo>();
		
		listOfClassesAndTodos.forEach((key, value) -> {
			if(key.getClassName().equals(classNameInput)) {
				List<Todo> courseTodos = listOfClassesAndTodos.get(key);
				
				for (Todo thisTodo : courseTodos) {					
					if (!thisTodo.getName().equals(todoNameInput)) {
						todosAfterRemoval.add(thisTodo);
					}
				}
			}
			
			listOfClassesAndTodos.put(key, todosAfterRemoval);
		});
	}
	
	public void completeInputTodo() {
		System.out.println("Enter the name of the class this todo falls under:");
		String classNameInput = getUserInput();

		System.out.println("Enter the name of the todo you would like to check off:");
		String todoNameInput = getUserInput();
		
		completeTodo(classNameInput, todoNameInput);
	}
	
	public void completeTodo(String classNameInput, String todoNameInput) {		
		listOfClassesAndTodos.forEach((key, value) -> {
			if(key.getClassName().equals(classNameInput)) {
				List<Todo> courseTodos = listOfClassesAndTodos.get(key);
				for (Todo thisTodo : courseTodos) {
					if (thisTodo.getName().equals(todoNameInput)) {
						thisTodo.setIsComplete();
						System.out.println();
						System.out.println(thisTodo.getName() + " has been marked as complete!");
					}
				}
			}
		});
	}
	
	public List<Todo> orderByPriority(Class className) {
		List<Todo> unorderedTodos = listOfClassesAndTodos.get(className);
		unorderedTodos.sort((o1, o2) -> 
			o1.getPriority().compareTo(o2.getPriority()));
		List<Todo> orderedTodos = unorderedTodos;
		return orderedTodos;
	}
	
	public List<Todo> todosOfSpecifiedPriority(Class className, String priority){
		List<Todo> priorityList = new ArrayList<>();
		listOfClassesAndTodos.get(className).forEach(value -> {
			if(value.getPriority().equals(priority)) {
				priorityList.add(value);
			}
		});
		
		return priorityList;
	}
	
	
}

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
	
	
	public Planner(Scanner scanner) {
		this.scanner = new Scanner(System.in);
		this.listOfClassesAndTodos = new HashMap<Class, List<Todo>>();
	}
	
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		Planner planner = new Planner(scanner);
		
		planner.printTodos(); //automatically prints current list (should start empty)
		System.out.println();
		//lists options of actions
		System.out.println("To add a class, enter C");
		System.out.println("To add a todo, enter T");
		System.out.println("To view your current list of classes and todos, enter L");
		System.out.println("To exit your planner, enter X");
		
		String input = getUserInput();
		while(!input.equals("X")) {
			if(input.equals("L")) {
				planner.printTodos();
			}
			else if(input.equals("C")) {
				//TODO: fill in for when a class is added
			}
			else if(input.equals("T")) {
				//TODO: fill in for when a todo item is added
				planner.addTodo();
			}
			else {
				System.out.println("That is an invalid command.");
			}
			input = getUserInput();
		}
	}
	
	public static String getUserInput() {
		String input = scanner.nextLine(); // read user input
		return input;
	}
	
	public void printTodos() {
		System.out.println("Your current classes and todos:");
		if(this.listOfClassesAndTodos != null) {
			System.out.println(this.listOfClassesAndTodos);
		}
		else {
			System.out.println("You currently have no classes or todos.");
		}
	}
	
	public void addClass(String className) {
		System.out.println("Enter the name of the course you want to add:");
		String coursename = getUserInput();
		Class course = new Class(coursename);
		listOfClassesAndTodos.put(course, null);
		
		}
	
	public void addTodo() {
		System.out.println("Enter the name of the class this todo falls under:");
		String className = getUserInput();
		
		if (!listOfClassesAndTodos.containsKey(className)) {
			System.out.println("This class does not exist. Enter 'A' to add this class, or 'R' to return to the main menu.");
			String input = getUserInput();
			if(input.equals("A")) {
				addClass(className);
			} else {
				//TODO: implement a mainMenu() method
			}
			return;
		}
		
		System.out.println("Enter the name of the todo you would like to add:");
		String todoName = getUserInput();
		System.out.println("Enter the due date of the todo:");
		String todoDate = getUserInput();
		System.out.println("Enter the todo's priority level (between 1-3):");
		String todoLevel = getUserInput();
		
		Todo todo = new Todo(todoName, todoDate, todoLevel);
		
		// add todo to the class
		listOfClassesAndTodos.get(className).add(todo);
		
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
	
	
	
}

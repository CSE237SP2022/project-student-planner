import java.util.Dictionary;
//import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * An object that represents student's academic planner
 * Contains a student's classes and the todo items associated with each class
 * @author Sophia Rosset
 * 
 */
public class Planner {

	private Scanner scanner;
	
	Dictionary<Class, List<Todo>> allTodos;
	
	public Planner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Planner planner = new Planner(scanner);
		
		planner.printTodos(); //automatically prints current list (should start empty)
		System.out.println();
		//lists options of actions
		System.out.println("To add a class, enter C");
		System.out.println("To add a todo, enter T");
		System.out.println("To view your current list of todos, enter L");
		System.out.println("To exit your planner, enter X");
		
		String input = planner.getClassInformation();
		while(!input.equals("X")) {
			if(input.equals("L")) {
				planner.printTodos();
			}
			else if(input.equals("C")) {
				//TODO: fill in for when a class is added
			}
			else if(input.equals("T")) {
				//TODO: fill in for when a todo item is added
			}
			else {
				System.out.println("That is an invalid command.");
			}
			input = planner.getClassInformation();
		}
	}
	
	public String getClassInformation() {
		String input = scanner.nextLine(); // read user input
		return input;
	
	}
	
	public void printTodos() {
		System.out.println("Your current list of todos:");
		if(this.allTodos != null) {
			System.out.println(this.allTodos);
		}
		else {
			System.out.println();
		}
	}
	
}

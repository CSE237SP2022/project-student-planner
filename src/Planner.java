import java.util.Scanner;

/**
 * An object that represents student's academic planner
 * Contains a student's classes and the todo items associated with each class
 * @author Sophia Rosset
 * 
 */
public class Planner {

	private Scanner scanner;
	
	public Planner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Planner planner = new Planner(scanner);
		planner.getClassInformation();
	}
	
	private void getClassInformation() {
		System.out.println("Enter class name: "); // ask for user input
		String className = scanner.nextLine(); // read user input
		System.out.println("Class name is: " + className); // output user input
	
	}
	
}

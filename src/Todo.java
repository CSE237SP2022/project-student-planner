
/**
 * An object that represents a todo item in a planner
 * @author Liza Kaniewski
 * 
 */
public class Todo {

	private String name;
	private String date; 
	
	public Todo(String name, String date) {
		this.name = name;
		this.date = date;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
}


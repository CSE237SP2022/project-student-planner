
/**
 * An object that represents a todo item in a planner
 * @author Liza Kaniewski
 * 
 */
public class Todo {

	private String name;
	private String date; 
	private String level; 
	
	public Todo(String name, String date, String level) {
		this.name = name;
		this.date = date;
		this.level = level;
	}
	
	public String getName() {
		return name;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getPriority() {
		return level;
	}
	
}


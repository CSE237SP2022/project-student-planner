
/**
 * An object that represents a todo item in a planner
 * @author Liza Kaniewski
 * 
 */
public class Todo {

	private String name;
	private String date; 
	private String level; 
	private Boolean isComplete;
	
	public Todo(String name, String date, String level, Boolean isComplete) {
		this.name = name;
		this.date = date;
		this.level = level;
		this.isComplete = false;
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
	
	public Boolean getIsComplete() {
		return isComplete;
	}
	
	public void setIsComplete() {
		this.isComplete = true;
	}
}


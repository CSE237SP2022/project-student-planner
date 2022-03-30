import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoTest {

	private Todo todo;
	
	@BeforeEach
	void setup() {
		todo = new Todo("essay", "April 1"); //setup
	}
	
	@Test
	void testGetName() {
		String name = todo.getName();
		assertTrue("essay".equals(name));
	}
	
	@Test
	void testGetDate() {
		String date = todo.getDate();
		assertTrue("April 1".equals(date));
	}

}

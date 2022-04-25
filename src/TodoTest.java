import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoTest {

	private Todo todo;
	
	@BeforeEach
	void setup() {
		todo = new Todo("essay", "April 1", "high", false); //setup
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
	
	@Test
	void testGetLevel() {
		String level = todo.getPriority();
		assertTrue("high".equals(level));
	}
	
	@Test
	void testGetIsComplete() {
		Boolean isComplete = todo.getIsComplete();
		assertTrue(false == isComplete);
	}
	
	@Test
	void testSetIsComplete() {
		todo.setIsComplete();
		Boolean isComplete = todo.getIsComplete();
		assertTrue(true == isComplete);
	}

}

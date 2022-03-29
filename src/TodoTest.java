import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoTest {

	private Todo todo;
	
	@BeforeEach
	void setup() {
		todo = new Todo("essay"); //setup
	}
	
	@Test
	void testGetName() {
		String name = todo.getName();
		assertTrue("essay".equals(name));
	}

}

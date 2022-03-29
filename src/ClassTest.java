import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ClassTest {
	
	private Class className;

	@BeforeEach
	void setUp() {
		className = new Class("237: Computer Science");
	}

	@Test
	void testGetClassName() {
		String name = className.getClassName();
		assertTrue("237: Computer Science".equals(name));
	}

}

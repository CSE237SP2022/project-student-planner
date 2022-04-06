import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseTest {

	private Course courseName;

	@BeforeEach
	void setUp() {
		courseName = new Course("237: Computer Science");
	}

	@Test
	void testGetClassName() {
		String name = courseName.getClassName();
		assertTrue("237: Computer Science".equals(name));
	}

}

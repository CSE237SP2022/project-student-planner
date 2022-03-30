import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlannerTest {

	private Planner planner;
	
	@BeforeEach
	void setup() {
		planner = new Planner(null); //setup
	}
	
	//How do we test for user input?
	@Test
	void testGetClassName() {
		String className = planner.getClassInformation();
		assertTrue("English".equals(className));
	}

}

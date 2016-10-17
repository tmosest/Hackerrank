package Implementation.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Implementation.AngryProfessor;

public class AngryProfessorTest {

	@Test
	public void testDeterminIfClassWillBeHeld() {
		int k0 = 3;
		int test0[] = {
				-1, -3, 4, 2
		};
		String result0 = AngryProfessor.determinIfClassWillBeHeld(test0, k0);
		assertEquals("YES", result0);
		
		int k1 = 2;
		int test1[] = {
				0, -1, 2, 1
		};
		String result1 = AngryProfessor.determinIfClassWillBeHeld(test1, k1);
		assertEquals("NO", result1);
	}

}

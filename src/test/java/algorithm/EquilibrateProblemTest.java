package algorithm;


import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EquilibrateProblemTest {
	@Test
	public void findMinDiffOfSubArray_should_give_min_diff() {
		int[] array = {1, 2, 3, 4, 5};
		assertEquals(1, EquilibrateProblem.findMinDiffOfSubArray(array));
	}
}

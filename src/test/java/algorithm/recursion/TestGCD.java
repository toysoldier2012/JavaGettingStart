package algorithm.recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestGCD {
	@Test
	public void should_gcd_return_gcd_of_two_integers(){
		assertEquals(4, GCD.recGCD(8, 12));
	}

	@Test
	public void should_gcd_return_0_1(){
		assertEquals(0, GCD.recGCD(-8, 12));
	}

	@Test
	public void should_gcd_return_0_2(){
		assertEquals(0, GCD.recGCD(0, 12));
	}

	@Test
	public void should_gcd_return_8(){
		assertEquals(8, GCD.recGCD(8, 0));
	}
}

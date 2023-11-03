package algorithm.recursion;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDecimalToBinary {
	@Test
	public void should_DecimalToBinary_return_1101001101(){
		assertEquals("1101001101", DecimalToBinary.recDecimalToBinary(845));
	}
}

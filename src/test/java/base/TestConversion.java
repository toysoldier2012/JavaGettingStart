package base;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestConversion {
	@Test
	public void should_return_string_as_integer(){
		assertEquals(123456, conversion.stringToInteger("123456"));
	}

	@Test
	public void should_return_string_as_float(){
		assertEquals(123456.123f, conversion.stringToFloat("123456.123"), 0.1);
	}

	@Test
	public void should_return_string_as_double(){
		assertEquals(123456.123, conversion.stringToDouble("123456.123"), 0.1);
	}
	@Test
	public void should_return_string_as_boolean(){
		assertTrue(conversion.stringToBoolean("true"));
	}

	@Test
	public void should_return_array_as_list(){
		List<Character> add = new ArrayList<Character>();
		add.add('1');
		assertEquals(add, conversion.arrayToList(new Character[]{}));
	}

	@Test
	public void test_testCharsToStream() {
		conversion.testCharsToStream();
	}
}

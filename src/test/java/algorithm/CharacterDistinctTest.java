package algorithm;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CharacterDistinctTest {
	@Test
	public void should_toto_do() {
		String s = "abcdemoderneancien1678452";
		assertEquals("cien1678452", CharacterDistinct.findLongestCharacter(s));
	}
}

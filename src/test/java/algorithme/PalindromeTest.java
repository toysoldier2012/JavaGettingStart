package algorithme;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PalindromeTest {
	@Test
	public void should_palindrome_find_right_string(){
		String[] strings = {"abc", "aba", "hello", "deed", "dead", "aaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbbbb",
				"abcdefgfedcba"};
		Palindrome palindrome = new Palindrome();
		List<String> stringList = new ArrayList<>();

		Arrays.stream(strings).forEach(str -> {
			if(palindrome.isStringPalindrome(str)) stringList.add(str);
		});

		assertEquals(3, stringList.size());
		assertEquals("abcdefgfedcba", stringList.get(2));
	}
}

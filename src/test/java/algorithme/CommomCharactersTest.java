package algorithme;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CommomCharactersTest {
	@Test
	public void should_do_toto() {
		List<Character> list = new ArrayList<>();
		list.add('a');
		list.add('e');
		list.add('e');
		list.add('e');

		List<Character> list2 = new ArrayList<>();
		list2.add('b');
		list2.add('b');
		list2.add('c');
		list2.add('e');
		list2.add('e');
		list2.add('g');

		List<Character> listRes = new ArrayList<>();
		listRes.add('e');
		listRes.add('e');

		assertEquals(listRes, CommonCharacters.findCommonCharacters(list, list2));
	}
}

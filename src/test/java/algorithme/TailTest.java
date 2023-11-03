package algorithme;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TailTest {
	@Test
	public void readFileLastLines_should_return_correct_lines(){
		Tail tail = new Tail();

		assertEquals("99999999999999900000000000000", tail.readFileLastLines("C:\\Users\\toysoldier\\Documents" +
				"\\IdeaProject\\preparation-entretien-sfeir\\src\\main\\resources\\test.txt", 2));
	}

}

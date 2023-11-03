package base;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class conversion {
	public static int stringToInteger(String s) {
		return Integer.parseInt(s);
	}
	public static float stringToFloat(String s) {
		return Float.parseFloat(s);
	}
	public static double stringToDouble(String s) {
		return Double.parseDouble(s);
	}

	public static boolean stringToBoolean(String s) {
		return Boolean.parseBoolean(s);
	}

	public static List<Character> arrayToList(Character[] array) {
		List<Character> list = new ArrayList<>(Arrays.asList(array));
		list.add('1');
		return list;
	}

	public static void testCharsToStream() {
		"abcdefg".chars().forEach(i -> System.out.println((char)i));
	}

	public static Integer[] listToArray(List<Integer> list){
		return list.toArray(new Integer[0]);
	}
}

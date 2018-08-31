package string;
public class StringExercise {

	// My trim method
	public static String trim(String str) {
		if (str.isEmpty())
			System.out.println("The String input is empty!");
		else {
			int start = 0;
			int end = str.length() - 1;
			while (start < end && str.charAt(start) == ' ')
				start++;
			while (start < end && str.charAt(end) == ' ')
				end--;
			str = str.substring(start, end);
		}
		return str;
	}

	// Reverser a char array
	public static char[] reverserChar(char[] c) {
		int a = c.length;
		char[] newchar = new char[a];

		for (int i = 0; i < c.length; i++)
			newchar[i] = c[c.length - 1 - i];

		return newchar;
	}

	// Reverser a char array from a begin to an end given
	public static char[] reverserChar(char[] c, int begin, int end) {
		char[] newchar = reverserChar(c);

		for (int i = 0; i < begin - 1; i++)
			newchar[i] = c[i];
		for (int i = end; i < c.length; i++)
			newchar[i] = c[i];

		return newchar;
	}

	// Reverser a word
	public static String reverserWord(String str) {
		char[] c = str.toCharArray();

		return new String(reverserChar(c));
	}

	// Reverser a part of word from a begin to an end given
	public static String reverserWord(String str, int start, int end) {
		return str.substring(0, start - 1) + reverserWord(str.substring(start - 1, end)) + str.substring(end);
	}

	// Count the times that substring appears in string
	public static int counter(String str, String substr) {
		int count = 0;
		int index = 0;

		while ((index = str.indexOf(substr, index)) != -1) {
			count++;
			index = index + substr.length();
		}

		return count;
	}

	// Get longer string from two
	public static String getLongerString(String str1, String str2) {
		if (str1.length() > str2.length()) {
			return str1;
		} else {
			return str2;
		}
	}

	// Get shorter string from two
	public static String getShorterString(String str1, String str2) {
		if (str1.length() > str2.length()) {
			return str2;
		} else {
			return str1;
		}
	}

	// Get the length of the longest same substring from two
	public static int longestSameSubstring(String str1, String str2) {
		int length = 0;
		String longString = getLongerString(str1, str2);
		String shortString = getShorterString(str1, str2);

		for (int i = 0; i < shortString.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (longString.indexOf(shortString.substring(j)) >= 0) {
					length = shortString.length() - i;
					return length;
				}
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		String str = "abcdefghcde   cd e   cde";
		String substr = "cde";

		System.out.println(reverserWord(str));
		System.out.println(reverserWord(str, 3, 6));

		System.out.println(counter(str, substr));

		System.out.println(longestSameSubstring(str, substr));
	}

}

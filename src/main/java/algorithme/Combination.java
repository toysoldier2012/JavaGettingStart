package algorithme;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public static void main(String[] args) {
		String[] arr = {"A", "B", "C", "D"};
		List<String> combinations = generateCombinations(arr);
		System.out.println(combinations.size());
		for (String combination : combinations) {
			System.out.println(combination);
		}
	}

	public static List<String> generateCombinations(String[] arr) {
		List<String> combinations = new ArrayList<>();
		generate(arr, 0, "", combinations);
		return combinations;
	}

	private static void generate(String[] arr, int index, String current, List<String> combinations) {
		if(index == arr.length) {
			combinations.add(current);
			return;
		}

		generate(arr, index + 1, current + arr[index], combinations);
		generate(arr, index + 1, current, combinations);
	}
}
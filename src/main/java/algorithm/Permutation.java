package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{
	public static void main(String[] args) {
		String[] strings = {"a", "b", "c"};
		List<String> stringList = generatePermutationList(strings);
		stringList.forEach(System.out::println);
	}

	public static List<String> generatePermutationList(String[] arr){
		List<String> permutationList = new ArrayList<>();
		generate(arr, 0, "", permutationList);
		return permutationList;
	}

	public static void generate(String[] arr, int index, String current, List<String> permutationList){
		if(index == arr.length) {
			permutationList.add(current);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			generate(arr, index + 1, current + arr[i], permutationList);
		}
	}
}

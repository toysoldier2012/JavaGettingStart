package algorithm;

import java.util.ArrayList;
import java.util.List;

public class CommonCharacters {
	public static List<Character> findCommonCharacters(List<Character> list1, List<Character> list2){
		List<Character> res = new ArrayList<>();

		int list1Index = 0;
		int list2Index = 0;

		while(list1Index < list1.size() && list2Index < list2.size()){
			if(list1.get(list1Index) < list2.get(list2Index)) {
				list1Index++;
			} else if(list1.get(list1Index) > list2.get(list2Index)) {
				list2Index++;
			} else {
				res.add(list1.get(list1Index));

				list1Index++;
				list2Index++;
			}
		}

		return res;
	}
}

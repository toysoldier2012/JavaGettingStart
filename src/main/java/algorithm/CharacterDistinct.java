package algorithm;

public class CharacterDistinct {
	public static String findLongestCharacter(String s) {
		if(s.length() <= 1) return s;

		int left = 0;
		int right = 1;
		int max = 0;
		String maxString = "";

		while(right != s.length()){
			int index = s.substring(left, right).indexOf(s.charAt(right));
			if( index != -1){
				left += index + 1;
			} else {
				if(right - left + 1 > max){
					maxString = s.substring(left, right + 1);
					max = right - left + 1;
				}
			}

			right++;
		}

		return maxString;
	}
}

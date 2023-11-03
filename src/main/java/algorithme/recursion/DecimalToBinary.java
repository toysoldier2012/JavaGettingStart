package algorithme.recursion;

public class DecimalToBinary {
	public static String recDecimalToBinary(int n){
		if(n == 1) return "1";
		return recDecimalToBinary(n/2) + n%2;
	}
}

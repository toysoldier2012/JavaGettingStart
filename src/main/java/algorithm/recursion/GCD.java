package algorithm.recursion;

public class GCD {
	public static int recGCD(int a, int b){
		if(a == 0) return 0;
		if(a < 0 || b < 0) return 0;
		if(b == 0) return a;
		return recGCD(b, a % b);
	}
}

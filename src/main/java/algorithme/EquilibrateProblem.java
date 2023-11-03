package algorithme;

import java.util.Arrays;

public class EquilibrateProblem {
	public static int findMinDiffOfSubArray(int[] array) {
		int sum = Arrays.stream(array).sum();

		int capa = sum / 2 + 1;
		int item = array.length + 1;

		int[][] dp = new int[item][capa];

		for (int i = 0; i < item; i++) {
			dp[i][0] = 0;
		}

		for (int j = 0; j < capa; j++) {
			dp[0][j] = 0;
		}

		for (int i = 1; i < item; i++) {
			for (int j = 1; j < capa; j++) {
				if (i > j) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], i + dp[i - 1][j - i]);
				}
			}
		}

		return sum - dp[array.length][sum / 2] * 2;
	}
}

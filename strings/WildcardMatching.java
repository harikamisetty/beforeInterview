package com.hari.dsal.strings;

public class WildcardMatching {
	// BEST Solution
	public boolean isMatch(String s, String p) {
		int i = 0;
		int j = 0;
		int starIndex = -1;
		int iIndex = -1;

		while (i < s.length()) {
			if (j < p.length() && (p.charAt(j) == '?' || p.charAt(j) == s.charAt(i))) {
				++i;
				++j;
			} else if (j < p.length() && p.charAt(j) == '*') {
				starIndex = j;
				iIndex = i;
				j++;
			} else if (starIndex != -1) {
				j = starIndex + 1;
				i = iIndex + 1;
				iIndex++;
			} else {
				return false;
			}
		}

		while (j < p.length() && p.charAt(j) == '*') {
			++j;
		}

		return j == p.length();
	}
	// Solution 2
	public boolean isMatch(String s, String p) {
		if (p == null || p.length() == 0) {
			return s == null || s.length() == 0;
		}

		int rows = s.length();
		int cols = p.length();

		boolean[][] dp = new boolean[rows + 1][cols + 1];

		dp[0][0] = true;
		for (int j = 1; j <= cols; j++) {
			if (p.charAt(j - 1) == '*') {
				dp[0][j] = dp[0][j - 1];
			}
		}

		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= cols; j++) {
				if (p.charAt(j - 1) != '*') {
					if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
						dp[i][j] = dp[i - 1][j - 1];
					}
				} else {
					dp[i][j] = dp[i - 1][j - 1] || dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}

		return dp[s.length()][p.length()];
	}

}

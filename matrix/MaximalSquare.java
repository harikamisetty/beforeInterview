package com.hari.dsal.matrix;

public class MaximalSquare {
	
	  /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
         
        int m = matrix.length;
        int n = matrix[0].length;
         
        int maxLen = 0;
         
        int[][] dp = new int[2][n];
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 1) {
                dp[0][i] = 1;
                maxLen = Math.max(maxLen, dp[0][i]);
            }
        }
         
        int cur = 0;
        int old = 0;
         
        for (int i = 1; i < m; i++) {
            old = cur;
            cur = 1 - cur;
            dp[cur][0] = matrix[i][0] == 1 ? 1 : 0;
            maxLen = Math.max(maxLen, dp[cur][0]);
             
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 1) {
                    dp[cur][j] = Math.min(dp[old][j - 1], Math.min(dp[old][j], dp[cur][j - 1])) + 1;
                } else {
                    dp[cur][j] = 0;
                }
                 
                maxLen = Math.max(maxLen, dp[cur][j]);
            }
        }
         
        return maxLen * maxLen;
         
    }
    
    /**
     * @param matrix: a matrix of 0 an 1
     * @return: an integer
     */
    public int maxSquare2(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
 
        int maxLen = 0;
 
        int m = matrix.length;
        int n = matrix[0].length;
 
        int[][] rowZeros = new int[m][n]; // most contignous zeros 
        int[][] colZeros = new int[m][n];
        int[][] dp = new int[2][n];
 
        for (int i = 0 ; i< m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    rowZeros[i][j] = 0;
                    colZeros[i][j] = 0;
                } else {
                    rowZeros[i][j] = j == 0 ? 1 : rowZeros[i][j - 1] + 1;
                    colZeros[i][j] = i == 0 ? 1 : colZeros[i - 1][j] + 1;
                }
            }
        }
 
        for (int i = 0; i < n; i++) {
            dp[0][i] = matrix[0][i];
            maxLen = Math.max(maxLen, dp[0][i]);
        }
 
        int cur = 0;
        int old = 0;
        for (int i = 1; i < m; i++) {
            old = cur;
            cur = 1 - cur;
            dp[cur][0] = matrix[i][0];
            maxLen = Math.max(maxLen, dp[cur][0]);
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    dp[cur][j] = 0;
                } else {
                    dp[cur][j] = Math.min(dp[old][j - 1], Math.min(rowZeros[i][j - 1], colZeros[i - 1][j])) + 1;
                }
 
                maxLen = Math.max(maxLen, dp[cur][j]);
            }
        }
 
        return maxLen * maxLen;
    }

}

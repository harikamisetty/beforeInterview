package com.hari.dsal.matrix;

import java.util.Arrays;
import java.util.Stack;

public class MaximalRectangle {
	
	 public int maximalRectangle(char[][] matrix) {
	        if (matrix == null || matrix.length == 0) {
	            return 0;
	        }
	         
	        int m = matrix.length;
	        int n = matrix[0].length;
	         
	        int[][] dp = new int[m][n];
	         
	        // initialization first row
	        for (int i = 0; i < n; i++) {
	            dp[0][i] = matrix[0][i] - '0';
	        }
	         
	        for (int i = 1; i < m; i++) {
	            for (int j = 0; j < n; j++) {
	                if (matrix[i][j] != '0') {
	                    dp[i][j] = dp[i - 1][j] + 1;
	                }
	            }
	        }
	         
	        // find the max rectanlge histogram
	        int max = 0;
	        for (int i = 0; i < m; i++) {
	            int localSum = maxRectangleHistogram(dp[i]);
	            max = Math.max(max, localSum);
	        }
	         
	        return max;
	    }
	     
	    private int maxRectangleHistogram(int[] height) {
	        if (height.length == 1) {
	            return height[0];
	        }
	         
	        Stack<Integer> stack = new Stack<Integer>();
	        int[] height2 = new int[height.length + 1];
	        height2 = Arrays.copyOf(height, height.length + 1);
	         
	        int i = 0;
	        int maxArea = 0;
	        while (i < height2.length) {
	            if (stack.isEmpty() || height2[i] > height2[stack.peek()]) {
	                stack.push(i);
	                i++;
	            } else {
	                int index = stack.pop();
	                int localMax = 0;
	                if (stack.isEmpty()) {
	                    localMax = height2[index] * i;
	                } else {
	                    localMax = height2[index] * (i - stack.peek() - 1);
	                }
	                maxArea = Math.max(maxArea, localMax);
	            }
	        }
	        return maxArea;
	    }

}

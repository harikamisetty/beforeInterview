package com.hari.dsal.arrays;

public class MaxSubArray {

	public int maxsubarray(int[] nums) {
		int n = nums.length;

		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];

		for (int i = 1; i < n; i++) {
			dp[i] = nums[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
	
	
	public static void main(String[] args) {
		int A[] = {-2,1,-3,4,-1,2,1,-5,4};
		MaxSubArray maxSubArray = new MaxSubArray();
		System.out.println(maxSubArray.maxsubarray(A));
	}
}

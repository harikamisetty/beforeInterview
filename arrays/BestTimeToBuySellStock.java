package com.hari.dsal.arrays;

public class BestTimeToBuySellStock {

	public static int maxProfit(int[] prices) {
		if (prices == null || prices.length <= 1)
			return 0;
		int min = prices[0]; // min so far
		int result = 0;
		for (int i = 1; i < prices.length; i++) {
			result = Math.max(result, prices[i] - min); // Fiind Max Profit
			min = Math.min(min, prices[i]); // Find the next min
		}
		return result;
	}	

	public static void main(String[] args) {
		int stocks[] = new int[10];
		stocks[0] = 10;
		stocks[1] = 20;
		stocks[2] = 30;
		stocks[3] = 15;
		stocks[4] = 25;
		stocks[5] = 50;
		System.out.println(maxProfit(stocks));
	}
}

package com.hari.test.rotateArray;

public class RotateArray {

	private int[] getSwapArray(int[] a, int k) {

		if (a == null || a.length == 0)
			return null;
		k = k % a.length; // Very Important if k > a.length

		reverse(a, 0, a.length - 1);
		reverse(a, 0, k - 1);
		reverse(a, k, a.length - 1);

		return a;
	}

	private void reverse(int[] a, int i, int j) {
		while (i < j) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		int [] a= {1,2,3};
		RotateArray r = new RotateArray();
		for(int val: r.getSwapArray(a, 0)) {
			System.out.print(val+" ");
		};
	}

}

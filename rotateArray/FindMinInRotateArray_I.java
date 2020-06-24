package com.hari.test.rotateArray;

public class FindMinInRotateArray_I {

	private int findmin(int[] a) {
		if(a ==null || a.length ==0)
			return -1;

		if(a.length ==1)
			return a[0];
		int start =0, end =a.length -1;

		while(start < end) {
			int mid = (start + end) /2;

			if(mid >0 && a[mid]<a[mid -1]) {
				return a[mid];
			}
			if(a[start] <= a[mid] && a[mid] > a[end]) {
				start = mid +1;
			} else {
				end = mid -1;
			}
		}
		return a[start]; // To return if the start and end equals
	}

	public static void main(String[] args) {
		int[] A= {4,5,6,7,0,1,2};
		int[] B= {3,2,1,0,4,5,6,7};
		int[] C= {3,2,1,4,5};
		FindMinInRotateArray_I smra = new FindMinInRotateArray_I();
		System.out.println(smra.findmin(A));
		//System.out.println(smra.findmin(C));
	}
}

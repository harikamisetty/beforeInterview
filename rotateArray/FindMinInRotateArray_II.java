package com.hari.test.rotateArray;

public class FindMinInRotateArray_II {


	private int findmin(int[] a) {
		if(a ==null || a.length ==0)
			return -1;

		if(a.length ==1)
			return a[0];
		int start =0, end =a.length -1;

		while (start < end) {
			int mid = (start + end) / 2;

			if (a[mid] < a[end]) {
				end = mid;
			} else if (a[mid] > a[end]) {
				start = mid + 1;
			} else {
				end--; // If all values are same
			}
		}
		return a[start];
	}

	public static void main(String[] args) {
		int[] A= {1,3,5};
		int[] B= {3,2,1,0,4,5,6,7};
		int[] C= {3,2,1,4,5};
		int[] D= {3,3,1,3};
		int[] E= {1,3,3};
		int[] F= {10,1,10,10,10};
		int[] G= {1,1,1,1};

		FindMinInRotateArray_II smra = new FindMinInRotateArray_II();

		System.out.println(smra.findmin(A));
		System.out.println(smra.findmin(B));
		System.out.println(smra.findmin(C));
		System.out.println(smra.findmin(D));
		System.out.println(smra.findmin(E));
		System.out.println(smra.findmin(F));
		System.out.println(smra.findmin(G));
	}
}

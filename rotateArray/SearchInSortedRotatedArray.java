package com.hari.test.rotateArray;

public class SearchInSortedRotatedArray {

	public int search(int[] A, int target) {
		if (A == null || A.length == 0) {
			return -1;
		}

		int lo = 0;
		int hi = A.length - 1;

		while (lo <= hi) {
			int mid = (lo + hi) / 2;
			if (A[mid] == target) {
				return mid;
			}

			if (A[lo] <= A[mid]) {
				if (target >= A[lo] && target < A[mid]) {
					hi = mid - 1;
				} else {
					lo = mid + 1;
				}
			} else {
				if (A[mid] < target && target <= A[hi]) {
					lo = mid + 1;
				} else {
					hi = mid - 1;
				}
			}
		}
		return -1;
	}


	public static void main(String[] args) {
		int A[] = { 4, 5, 6, 7, 0, 1, 2, 3 };
		int[] B= {3,2,1,0,4,5,6,7};
		int[] C= {3,2,1,4,5};
		SearchInSortedRotatedArray sear = new SearchInSortedRotatedArray();
		System.out.println(sear.search(A, 2));
		System.out.println(sear.search(B, 2));
		System.out.println(sear.search(C, 2));

	}
}

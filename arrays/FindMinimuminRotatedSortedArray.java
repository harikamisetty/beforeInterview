package com.hari.dsal.arrays;

public class FindMinimuminRotatedSortedArray {
	
	public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
         
        int lo = 0;
        int hi = nums.length - 1;
         
        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;
             
            if (nums[lo] < nums[hi]) {
                return nums[lo];
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[lo] < nums[mid]) {
                lo = mid;
            }
        }
         
        return Math.min(nums[lo], nums[hi]);
    }
	
	public static void main(String[] args) {
		int[] A= {4,5,6,7,0,1,2,3};
		FindMinimuminRotatedSortedArray fmrsa = new FindMinimuminRotatedSortedArray();
		System.out.println(fmrsa.findMin(A));
	}
}

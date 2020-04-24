package com.hari.dsal.arrays;

public class MajorityElement { // Wrong Solution

	public int majorityelement(int[] nums) {

		int major = nums[0], count = 1;

		for (int i = 1; i < nums.length; i++) {

			if (count == 0) {
				count++;
				major = nums[i];
			} else if (major == nums[i]) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}
	
	public static void main(String[] args) {
		
		int A[] = {2,3,4,5,2,6,7};
		
		MajorityElement majele = new MajorityElement();
		System.out.println(majele.majorityelement(A));
	}
}

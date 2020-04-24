package com.hari.dsal.arrays;

public class ContainerWithMostWater {
	
	public int maxArea(int[] height) {
        if (height == null || height.length <= 1) 
            return 0;
             
        int lo = 0;
        int hi = height.length - 1;
        int max = 0; 
         
        while (lo < hi) {
            max = Math.max(max, (hi - lo) * Math.min(height[lo], height[hi]));
            if (height[lo] < height[hi]) lo++;
            else hi--;
        }
        return max;
    }
	
	public static void main(String[] args) {
		int A[] = {3,5,7,8,23,45,87};
		ContainerWithMostWater cwmw = new ContainerWithMostWater();
		System.out.println(cwmw.maxArea(A));
		
	}

}

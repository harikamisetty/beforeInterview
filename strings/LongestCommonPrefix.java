package com.hari.dsal.strings;

import java.util.Arrays;

public class LongestCommonPrefix {
	private String getCommonPrefix(String[] strs) {
		if(strs == null || strs.length ==0)
			return null;

		Arrays.sort(strs);
		char[] first = strs[0].toCharArray();
		char[] last  = strs[strs.length-1].toCharArray();

		for(int i=0; i<first.length; i++) {
			if(first[i] != last[i])
				return String.valueOf(first).substring(0, i);
			if(i == first.length-1)
				return String.valueOf(first);
		}
		return null;
	}
	
	public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String longestCommonPrefix = strs[0];
        
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            String currentString = strs[i];
            
            while (j < longestCommonPrefix.length() && j < currentString.length() && longestCommonPrefix.charAt(j) == currentString.charAt(j)) {
                j++;
            }
            
            if (j == 0) {
                return "";
            }
            
            longestCommonPrefix = longestCommonPrefix.substring(0, j);
        }
        
        return longestCommonPrefix;
    }
	
	public static String longestCommonPrefixds(String[] strs) {
		
		StringBuilder results = new StringBuilder();
		
		if(strs != null && strs.length > 0) {
			Arrays.sort(strs);
			char[] a = strs[0].toCharArray();
			char[] b = strs[strs.length-1].toCharArray();
			
			for(int i=0; i < a.length; i++) {
				if(b.length > i && b[i] == a[i]) {
					results.append(b[i]);
				} else {
					return results.toString();
				}
			}
		}
		return results.toString();
	}
	
	public static void main(String[] args) {
		
		String []strs = {"howtosolv","howtoproblem","howtoemyname","howtosolv","howtosolvemyname"};
		
		System.out.println(longestCommonPrefixds(strs));
		
	}

}

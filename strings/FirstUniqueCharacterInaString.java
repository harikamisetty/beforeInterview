package com.hari.dsal.strings;

public class FirstUniqueCharacterInaString {

	public int firstUniqChar(String s) {
		if (s == null || s.length() == 0) {
			return -1;
		}

		int[] counts = new int[26];

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			counts[c - 'a']++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (counts[c - 'a'] == 1) {
				return i;
			}
		}

		return -1;
	}
	// Best Solution
	private int getFirstUChar(String str) {

		Map<Character, Integer> charMap = new HashMap<>();

		for(int i=0; i <str.length(); i++) {
			if(charMap.containsKey(str.charAt(i))) {
				charMap.put(str.charAt(i), -1);
			} else {
				charMap.put(str.charAt(i), i);
			}
		}
		int min = Integer.MAX_VALUE;
		for(char c : charMap.keySet()) {
			if(charMap.get(c) != -1 && charMap.get(c)<min)
				min = charMap.get(c);
		}
		return min;
	}

}

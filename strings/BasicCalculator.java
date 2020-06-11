package com.hari.test.practice;

import java.util.Stack;

public class BasicCalculator {


	private int getCalculatedResult(String s) {
		if(s== null || s.length()==0)
			return 0;

		Stack<Integer> stack = new Stack<>();
		char sign ='+';
		int num =0;
		int len = s.length();

		for(int i=0; i < s.length(); i++) {
			if(Character.isDigit(s.charAt(i))) {
				num = num * 10 + (s.charAt(i) - '0');
			}
			if((!Character.isDigit(s.charAt(i)) && ' '!=s.charAt(i) || i == len -1)){
				if(sign == '-') {
					stack.push(-num);
				}
				if(sign == '+') {
					stack.push(num);
				}
				if(sign == '*') {
					stack.push(stack.pop() * num);
				}
				if(sign == '/') {
					stack.push(stack.pop() / num);
				}
				sign = s.charAt(i);
				num = 0;
			}
		}
		int re = 0;
		for(int i : stack) {
			re+=i;
		}
		return re;
	}
	public static void main(String[] args) {
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.getCalculatedResult("2*33*45"));
	}
}

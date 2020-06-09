package com.hari.dsal.strings;

import java.util.Stack;

public class BasicCalculater {
	
	// Best Solution
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
	
	// Solution 2
	public int calculate(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		s = s.trim();
		s = s.replaceAll("[ ]+", "");

		Stack<Integer> numStack = new Stack<>();
		Stack<Character> opStack = new Stack<>();

		int ans = 0;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				int num = 0;
				while (i < s.length() && Character.isDigit(s.charAt(i))) {
					int digit = Character.getNumericValue(s.charAt(i));
					num = num * 10 + digit;
					i++;
				}
				numStack.push(num);
			} else {
				if (opStack.isEmpty() || c == '(') {
					opStack.push(c);
					i++;
				} else if (c == '*' || c == '/') {
					if (opStack.peek() == '*' || opStack.peek() == '/') {
						compute(numStack, opStack);
					} else {
						opStack.push(c);
						i++;
					}
				} else if (c == '+' || c == '-') {
					compute(numStack, opStack);
				} else if (c == ')') {
					while (!opStack.isEmpty() && opStack.peek() != '(') {
						compute(numStack, opStack);
					}
					opStack.pop();
					i++;
				}
			}
		}

		while (!opStack.isEmpty()) {
			compute(numStack, opStack);
		}

		return numStack.pop();
	}

	private void compute(Stack<Integer> numStack, Stack<Character> opStack) {
		int num2 = numStack.pop();
		int num1 = numStack.pop();

		char op = opStack.pop();

		int ans = 0;

		switch (op) {
		case '+':
			ans = num1 + num2;
			break;
		case '-':
			ans = num1 - num2;
			break;
		case '*':
			ans = num1 * num2;
			break;
		case '/':
			ans = num1 / num2;
			break;
		}

		numStack.push(ans);
	}

}

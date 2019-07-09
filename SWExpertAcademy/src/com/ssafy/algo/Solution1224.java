package com.ssafy.algo;

import java.util.Scanner;
import java.util.Stack;

// 그냥하기 
// 괄호만을 위한 if 구문을 추가
// 닫히면 열림 나올때까지 팝
// 열리면 무조건 푸쉬

public class Solution1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<>();
		Stack<Integer> nums = new Stack<>();

		for (int T = 1; T <= 10; T++) {
			int N = sc.nextInt();
			String expr = sc.next();
			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < expr.length(); i++) {
				char c = expr.charAt(i);
				if (Character.isDigit(c))
					sb.append(c);
				else {
					if (c == '(') 
						stack.push(c);
					else if (c == ')') {
						while (stack.peek() != '(')
							sb.append(stack.pop());
						stack.pop();
					} else {
						while (!stack.isEmpty() && (pre(c) <= pre(stack.peek())))
							sb.append(stack.pop());
						stack.push(c);
					}
				}
			}

			while (!stack.isEmpty())
				sb.append(stack.pop());

			for (int i = 0; i < sb.length(); i++) {
				if (Character.isDigit(sb.charAt(i)))
					nums.push(sb.charAt(i) - '0');
				else {
					int num1 = nums.pop();
					int num2 = nums.pop();

					switch (sb.charAt(i)) {
					case '+':
						nums.push(num2 + num1);
						break;
					case '-':
						nums.push(num2 - num1);
					case '*':
						nums.push(num2 * num1);
						break;
					case '/':
						nums.push(num2 / num1);
						break;
					}
				}
			}
			System.out.printf("#%d %d%n", T, nums.pop());
		}
	}

	static int pre(char c) {
		switch (c) {
		case '*':
		case '/':
			return 2;
		case '+':
		case '-':
			return 1;
		}
		return 0;
	}
}
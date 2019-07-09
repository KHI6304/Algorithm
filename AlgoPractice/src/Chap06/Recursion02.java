package Chap06;

import java.util.Stack;

public class Recursion02 {
	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		recur(5, stack, 2);
	}
	
	static void recur(int n, Stack<Integer> picked, int toPick) {
		if( toPick == 0 ) {
			for(int num : picked)
				System.out.print(num + " ");
			System.out.println();
			return;
		}
		
		int smallest = picked.isEmpty() ? 0 : picked.peek() + 1;
		
		for(int next = smallest; next < n; ++next) {
			picked.push(next);
			recur(n, picked, toPick - 1);
			picked.pop();
		}
	}
}
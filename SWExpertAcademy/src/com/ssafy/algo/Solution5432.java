package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution5432 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			char[] inp = br.readLine().toCharArray();
			Stack<Character> stack = new Stack<>();
			
			int cnt = 0;
			boolean check = false;
			for(char c : inp) {
				if(c == '(') {
					stack.push(c);
					check = false;
				}
				else {
					if(check) {
						stack.pop();
						cnt += 1;
					}
					else {
						stack.pop();
						cnt += stack.size();
					}
					check = true;
				}
			}
			
			sb.append("#").append(tc).append(" ").append(cnt).append("\n");
		}
		System.out.print(sb);
	}
}
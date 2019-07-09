package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4261 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			String S = st.nextToken();
			int N = Integer.parseInt(st.nextToken());
			
			String[] sol = new String[N];
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; i++)
				sol[i] = solve(st.nextToken());
			
			int cnt = 0;
			for(String s : sol) {
				if(s.equals(S)) {
					cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}
	
	static String solve(String s) {
		
		String[] strs = {
				"",
				"",
				"abc",
				"def",
				"ghi",
				"jkl",
				"mno",
				"pqrs",
				"tuv",
				"wxyz"
		};
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			String tmp = s.charAt(i) + "";
			for(int j = 2; j <= 9; j++) {
				if(strs[j].contains(tmp)) {
					sb.append(j);
					break;
				}
			}
		}
		
		return sb.toString();
	}
}
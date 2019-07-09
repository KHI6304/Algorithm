package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5247 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			sol = Integer.MAX_VALUE;
			solve(N, M, 0);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static void solve(int N, int M, int cnt) {
		if(N > 1000000 || N <= 0)
			return;
		
		if(sol < cnt)
			return;
		
		if(N == M) {
			sol = Math.min(sol, cnt);
			return;
		}
		
		solve(N * 2, M, cnt + 1);
		solve(N - 10, M, cnt + 1);
		solve(N + 1, M, cnt + 1);
		solve(N - 1, M, cnt + 1);
	}
}
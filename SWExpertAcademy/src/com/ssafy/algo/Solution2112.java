package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution2112 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			// D(두께), W(가로크기), K(합격기준)
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W];
			int[][] m = new int[D][W];
			for(int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
				m[i] = Arrays.copyOf(map[i], W);
			}
			sol = Integer.MAX_VALUE;
			solve(m, 0, 0);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int D;
	static int W;
	static int K;
	static int[][] map;
	static int sol;
	
	static void solve(int[][] m, int depth, int cnt) {
		if(depth == D) {
			if(isOk(m))
				sol = Math.min(sol, cnt);
			return;
		}
		
		if(sol < cnt)
			return;
		
		if(isOk(m)) {
			sol = Math.min(sol, cnt);
			return;
		}
		
		Arrays.fill(m[depth], 1);
		solve(m, depth + 1, cnt + 1);
		Arrays.fill(m[depth], 0);
		solve(m, depth + 1, cnt + 1);
		
		m[depth] = Arrays.copyOf(map[depth], W);
		solve(m, depth + 1, cnt);
		
	}
	
	static boolean isOk(int[][] map) {
		boolean returnFlag = true;
		
		for(int i = 0; i < W && returnFlag; i++) {
			
			int num = map[0][i];
			int cnt = 1;
			
			boolean flag = true;
			for(int j = 1; j < D && flag; j++) {
				if(num != map[j][i]) {
					cnt = 1;
					num = map[j][i];
				}
				else if(num == map[j][i])
					cnt++;
				
				if(cnt == K)
					flag = false;
			}
			
			if(flag)
				returnFlag = false;
		}
		
		return returnFlag;
	}
	
}
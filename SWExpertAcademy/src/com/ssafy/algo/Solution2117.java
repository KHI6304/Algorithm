package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2117 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			List<int[]> list = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1)
						list.add(new int[] {i, j});
				}
			}
			
			int sol = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 1; k <= 2 * Math.max(N - i, N - j) - 1; k++) {
						int profit = -( k * k + (k - 1) * (k - 1) );
						
						int cnt = 0;
						for(int[] tmp : list) {
							int x = tmp[0];
							int y = tmp[1];
							int dist = Math.abs(x - i) + Math.abs(y - j);
							
							if(dist <= k - 1) {
								profit += M;
								cnt++;
							}
						}
						if(profit >= 0)
							sol = Math.max(sol, cnt);
					}
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}
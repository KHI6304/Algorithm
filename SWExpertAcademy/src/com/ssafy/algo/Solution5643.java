package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution5643 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			int M = Integer.parseInt(br.readLine().trim());

			map = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken().trim());
				int b = Integer.parseInt(st.nextToken().trim());

				map[a][b] = 1;
			}

			int sol = 0;
			cntUp = new int[N + 1];
			cntDown = new int[N + 1];
			for (a = 1; a <= N; a++) {
				boolean[] visited = new boolean[N + 1];
				
				solve(visited, a, 1);
				
			}
			
			for(int i = 1; i <= N; i++)
				if(cntUp[i] + cntDown[i] == N - 1)
					sol++;
			
			System.out.println("#" + tc + " " + sol);
		}
	}

	static int N;
	static int[][] map;
	static int[] cntUp;
	static int[] cntDown;
	static int a;

	static void solve(boolean[] visited, int n, int cnt) {
		for (int i = 1; i <= N; i++) {
			if (map[n][i] == 1 && !visited[i]) {
				visited[i] = true;
				cntUp[a]++;
				cntDown[i]++;
				solve(visited, i, cnt + 1);
			}
		}
	}
}
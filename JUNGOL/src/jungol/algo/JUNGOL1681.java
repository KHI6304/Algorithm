package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUNGOL1681 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken().trim());
		}
		
		solve(new boolean[N], 0, 0, 0);
		System.out.println(sol);
	}
	
	static int N;
	static int[][] map;
	static int sol = Integer.MAX_VALUE;
	
	static void solve(boolean[] visited, int cnt, int cost, int idx) {
		if(cnt == N) {
			sol = Math.min(sol, cost);
			return;
		}
		
		if(cost > sol)
			return;
		
		for(int i = 0; i < N; i++) {
			if(cnt != N - 1 && i == 0)
				continue;
			
			if(!visited[i] && map[idx][i] != 0) {
				visited[i] = true;
				solve(visited, cnt + 1, cost + map[idx][i], i);
				visited[i] = false;
			}
		}
	}
}
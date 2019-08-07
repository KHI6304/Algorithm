package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main14620 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		solve(0, 0, 1);
		System.out.println(sol);
	}
	
	private static int[] dx = {0, -1, 1, 0, 0};
	private static int[] dy = {0, 0, 0, -1, 1};
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int sol = Integer.MAX_VALUE;
	
	private static void solve(int cost, int cnt, int x) {
		if(cnt == 3) {
			sol = Math.min(sol, cost);
			return;
		}
		
		for(int r = x; r < N - 1; r++) {
			for(int c = 1; c < N - 1; c++) {
				if( !isOk(r, c) )
					continue;
				
				int nCost = Plant(r, c);
				
				solve(cost + nCost, cnt + 1, r);
				
				Pluck(r, c);
			}
		}
	}
	
	private static boolean isOk(int x, int y) {
		boolean flag = true;
		for(int d = 0; d < 5; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(visited[nx][ny]) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
	private static int Plant(int x, int y) {
		int cost = 0;
		for(int d = 0; d < 5; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			cost += map[nx][ny];
			visited[nx][ny] = true;
		}
		return cost;
	}
	
	private static void Pluck(int x, int y) {
		for(int d = 0; d < 5; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			visited[nx][ny] = false;
		}
	}
}
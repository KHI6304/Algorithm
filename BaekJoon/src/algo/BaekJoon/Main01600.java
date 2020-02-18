package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01600 {
	private static class Monkey {
		int x, y, cnt, k;

		public Monkey(int x, int y, int cnt, int k) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.k = k;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][W];
		visited = new boolean[H][W][K + 1];
		for(int r = 0; r < H; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < W; c++)
				map[r][c] = Integer.parseInt(st.nextToken());
		}
		 
		sol = Integer.MAX_VALUE;
		
		BFS();
		
		System.out.println(sol == Integer.MAX_VALUE ? -1 : sol);
	}
	
	private static int K;
	private static int W;
	private static int H;
	private static int[][] map;
	private static boolean[][][] visited;
	private static int[] dx = {0, 0, -1, 1};
	private static int[] dy = {-1, 1, 0, 0};
	private static int[] hx = {-1, -2, -2, -1, 1, 2, 2, 1};
	private static int[] hy = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int sol;
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < H && ny < W;
	}
	
	private static void BFS() {
		Queue<Monkey> q = new LinkedList<>();
		q.add(new Monkey(0, 0, 0, K));
		visited[0][0][K] = true;
		
		while(!q.isEmpty()) {
			Monkey tmp = q.poll();
			
			if(tmp.x == H - 1 && tmp.y == W - 1) {
				sol = tmp.cnt;
				return;
			}
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == 1 || visited[nx][ny][tmp.k]) continue;
				visited[nx][ny][tmp.k] = true;
				
				q.add(new Monkey(nx, ny, tmp.cnt + 1, tmp.k));
			}
			
			if(tmp.k == 0) continue;
			
			for(int d = 0; d < 8; d++) {
				int nx = tmp.x + hx[d];
				int ny = tmp.y + hy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == 1 || visited[nx][ny][tmp.k - 1]) continue;
				visited[nx][ny][tmp.k - 1] = true;
				
				q.add(new Monkey(nx, ny, tmp.cnt + 1, tmp.k - 1));
			}
		}
	}
}
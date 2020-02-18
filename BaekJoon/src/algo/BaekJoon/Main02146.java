package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02146 {
	private static class Dot {
		int x, y, dist;

		public Dot(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int num = 2;
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] != 1) continue;
				
				numbering(new Dot(r, c, 0), num++);
			}
		}
		
		sol = Integer.MAX_VALUE;
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == 0 || !isEdge(r, c)) continue;
				
				BFS(new Dot(r, c, 0), map[r][c]);
			}
		}
		
		System.out.println(sol);
	}
	
	private static int N;
	private static int[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int sol;
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	private static void numbering(Dot dot, int num) {
		Queue<Dot> q = new LinkedList<>();
		q.add(dot);
		map[dot.x][dot.y] = num;
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] != 1) continue;
				
				map[nx][ny] = num;
				q.add(new Dot(nx, ny, 0));
			}
		}
	}
	
	private static boolean isEdge(int x, int y) {
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!inRange(nx, ny) || map[nx][ny] != 0) continue;
			
			return true;
		}
		return false;
	}
	
	private static void BFS(Dot dot, int num) {
		visited = new boolean[N][N];
		
		Queue<Dot> q = new LinkedList<>();
		q.add(dot);
		
		boolean flag = true;
		while(!q.isEmpty() && flag) {
			Dot tmp = q.poll();
			
			if(tmp.dist >= sol) break;
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || map[nx][ny] == num || visited[nx][ny]) continue;
				
				if(map[nx][ny] != 0) {
					sol = Math.min(sol, tmp.dist);
					flag = false;
					break;
				}
				
				q.add(new Dot(nx, ny, tmp.dist + 1));
				visited[nx][ny] = true;
			}
		}
	}
}
package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02589 {
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
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		map = new char[Row][Col];
		
		for(int r = 0; r < Row; r++)
			map[r] = br.readLine().toCharArray();
		
		sol = Integer.MIN_VALUE;
		for(int r = 0; r < Row; r++) {
			for(int c = 0; c < Col; c++) {
				if(map[r][c] == 'W') continue;
				
				BFS(new Dot(r, c, 0));
			}
		}
		
		System.out.println(sol);
	}
	
	private static int Row;
	private static int Col;
	private static char[][] map;
	private static int sol;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	private static void BFS(Dot dot) {
		boolean[][] visited = new boolean[Row][Col];
		Queue<Dot> q = new LinkedList<Dot>();
		q.add(dot);
		visited[dot.x][dot.y] = true;
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			
			sol = Math.max(sol, tmp.dist);
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] != 'L') continue;
				
				q.add(new Dot(nx, ny, tmp.dist + 1));
				visited[nx][ny] = true;
			}
		}
	}
}
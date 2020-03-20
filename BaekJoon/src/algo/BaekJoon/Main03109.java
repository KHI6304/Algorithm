package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03109 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		visited = new boolean[R][C];
		for(int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		sol = 0;
		for(int r = 0; r < R; r++) {
			visited[r][0] = true;
			DFS(r, 0);
		}
		System.out.println(sol);
	}
	
	private static int R, C;
	private static char[][] map;
	private static boolean[][] visited;
	private static int sol;
	
	private static int[] dx = {-1, 0, 1};
	private static int[] dy = {1, 1, 1};
	
	private static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < R && y < C;
	}
	
	private static boolean DFS(int x, int y) {
		if(y == C - 1) {
			sol++;
			return true;
		}
		
		for(int d = 0; d < 3; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 'x') continue;
			
			visited[nx][ny] = true;
			if(DFS(nx, ny)) return true;
		}
		
		return false;
	}
}
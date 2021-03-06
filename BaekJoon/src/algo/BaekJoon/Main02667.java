package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main02667 {
	private static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		visited = new boolean[N][N];
		ans = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(map[r][c] == '0' || visited[r][c]) continue;
				
				BFS(new Position(r, c));
			}
		}
		
		Collections.sort(ans);
		System.out.println(ans.size());
		for(int cnt : ans)
			System.out.println(cnt);
	}
	
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	private static ArrayList<Integer> ans;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	private static void BFS(Position p) {
		Queue<Position> q = new LinkedList<>();
		q.add(p);
		visited[p.x][p.y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Position tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny)) continue;
				if(visited[nx][ny] || map[nx][ny] == '0') continue;
				
				visited[nx][ny] = true;
				cnt++;
				q.add(new Position(nx, ny));
			}
		}
		
		ans.add(cnt);
	}
}
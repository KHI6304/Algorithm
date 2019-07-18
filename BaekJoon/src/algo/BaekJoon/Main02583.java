package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02583 {
	static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		sol = new LinkedList<>();
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int ly = Integer.parseInt(st.nextToken());
			int lx = Integer.parseInt(st.nextToken());
			int ry = Integer.parseInt(st.nextToken()) - 1;
			int rx = Integer.parseInt(st.nextToken()) - 1;
			
			for(int j = lx; j <= rx; j++) {
				for(int k = ly; k <= ry; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(map[i][j] == 0 && !visited[i][j])
					recur(new Pos(i, j));
			}
		}
		
		Collections.sort(sol);
		System.out.println(sol.size());
		for(int i : sol)
			System.out.print(i + " ");
	}
	
	static boolean[][] visited;
	static int[][] map;
	static int R;
	static int C;
	static List<Integer> sol;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static void recur(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		int cnt = 1;
		visited[p.x][p.y] = true;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(!visited[nx][ny] && map[nx][ny] == 0) {
					q.add(new Pos(nx, ny));
					visited[nx][ny] = true;
					cnt++;
				}
			}
		}
		
		sol.add(cnt);
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < R && ny < C;
	}
}
	
package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02468 {
	private static class Dot {
		int x, y;

		public Dot(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		copy = new int[N][N];
		ans = Integer.MIN_VALUE;
		maxHeight = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				maxHeight = Math.max(maxHeight, map[i][j]);
			}
		}
		
		flood();
		
		System.out.println(ans);
	}
	
	private static int N;
	private static int[][] map;
	private static int[][] copy;
	private static int maxHeight;
	private static int ans;
	
	private static void copyMap() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				copy[i][j] = map[i][j];
	}
	
	private static void flood() {
		for(int h = 0; h < maxHeight; h++) {
			copyMap();
			
			for(int r = 0; r < N; r++)
				for(int c = 0; c < N; c++)
					if(copy[r][c] <= h)
						copy[r][c] = 0;
			
			int cnt = 0;
			for(int r = 0; r < N; r++) {
				for(int c = 0; c < N; c++) {
					if(copy[r][c] == 0) continue;
					
					cnt++;
					getSafeArea(new Dot(r, c));
				}
			}
			
			ans = Math.max(ans, cnt);
		}
	}
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static void getSafeArea(Dot dot) {
		Queue<Dot> q = new LinkedList<>();
		q.add(dot);
		copy[dot.x][dot.y] = 0;
		
		while(!q.isEmpty()) {
			Dot tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || copy[nx][ny] == 0) continue;
				
				q.add(new Dot(nx, ny));
				copy[nx][ny] = 0;
			}
		}
	}
}
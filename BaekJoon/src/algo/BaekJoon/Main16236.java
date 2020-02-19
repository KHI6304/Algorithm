package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main16236 {
	private static class Shark {
		int x, y, size, cnt;

		public Shark(int x, int y, int size, int cnt) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = cnt;
		}
	}
	
	private static class Fish {
		int x, y, size;

		public Fish(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9)
					shark = new Shark(i, j, 2, 0);
			}
		}
		
		
	}
	
	private static int N;
	private static int[][] map;
	private static Shark shark;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	private static void BFS(Shark s) {
		
	}
}
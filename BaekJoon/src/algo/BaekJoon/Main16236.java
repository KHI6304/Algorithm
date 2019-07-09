package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16236 {
	static class Shark {
		int x;
		int y;
		int size;
		int cnt;
		
		public Shark(int x, int y, int size) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.cnt = 0;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				s = new Shark(i, j, 2);
			}
		}
		
		
	}
	
	static Shark s;
	static int[][] map;
	static int N;
}
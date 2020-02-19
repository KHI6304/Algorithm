package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main03055 {
	private static class Dot {
		int x, y;

		public Dot(int x, int y) {
			super();
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
		
		map = new char[R][C];
		for(int r = 0; r < R; r++) {
			map[r] = br.readLine().toCharArray();
			for(int c = 0; c < C; c++) {
				
			}
		}
	}
	
	private static int R;
	private static int C;
	private static char[][] map;
	
	
}
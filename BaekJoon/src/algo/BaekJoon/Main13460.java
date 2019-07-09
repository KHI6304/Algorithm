package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main13460 {
	static class Red {
		int x;
		int y;
		
		public Red(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Blue {
		int x;
		int y;
		
		public Blue(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int Row = Integer.parseInt(st.nextToken());
		int Col = Integer.parseInt(st.nextToken());
		
		char[][] map = new char[Row][Col];
		Red r = null;
		Blue b = null;
		for(int i = 0; i < Row; i++) {
			String inp = br.readLine();
			for(int j = 0; j < Col; j++) {
				map[i][j] = inp.charAt(j);
				if(map[i][j] == 'R')
					r = new Red(i, j);
				if(map[i][j] == 'B')
					b = new Blue(i, j);
			}
		}
		
		
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean redFlag = false;
	static boolean blueFlag = false;
	static int sol;
	
	static void deepCopy(char[][] src, char[][] copy) {
		for(int i = 0; i < src.length; i++)
			for(int j = 0; j < src[i].length; j++)
				copy[i][j] = src[i][j];
	}
	
	static void solve(char[][] map, Blue b, Red r, int cnt) {
		if(cnt == 11)
			return;
		if(blueFlag) {
			redFlag = false;
			blueFlag = false;
			return;
		}
		if(redFlag) {
			redFlag = false;
			sol = Math.min(sol, cnt);
			return;
		}
		
		char[][] copy = new char[ map.length ][ map[0].length ];
		for(int i = 0; i < 4; i++) {
			
		}
		deepCopy(map, copy);
	}
}























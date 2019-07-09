package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01726 {
	static boolean[][][] visited;
	static int row;
	static int col;
	static int[][] map;
	
	static class Robot {
		int x;
		int y;
		int d;	// 방향
		int cnt;
		
		public Robot(int x, int y, int d, int cnt) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] map = new int[row + 1][col + 1];
		
		for(int i = 1; i <= row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		Robot start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
		st = new StringTokenizer(br.readLine());
		Robot end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 0);
	}
	
	static boolean inRange(int nx, int ny) {
		return nx > 0 && ny > 0 && nx <= row && ny <= col;
	}
}
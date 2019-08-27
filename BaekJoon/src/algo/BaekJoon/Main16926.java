package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main16926 {
	static int Row, Col, R, num;
	static int[][] map;
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		Row = Integer.parseInt(st.nextToken());
		Col = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[Row][Col];
		for(int i = 0; i < Row; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < Col; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		num = Math.min(Row, Col) / 2;
		
		for(int i = 0; i < R; i++)
			solve();
		
		print();
	}
	
	private static void print() {
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++)
				System.out.printf("%d ", map[i][j]);
			System.out.println();
		}
//		System.out.println("------------------------");
	}
	
	private static void solve() {
		for(int n = 0; n < num; n++) {
			int startVal = map[n][n];
			
			int idx = 0;
			int x = n, y = n;
			while(idx < 4) {
				int nx = x + dx[idx];
				int ny = y + dy[idx];
				
				if(nx >= n && ny >= n && nx < Row - n && ny < Col - n) {
					map[x][y] = map[nx][ny];
					x = nx;
					y = ny;
				}
				else
					idx++;
			}
			map[n + 1][n] = startVal;
		}
//		print();
	}
}
package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01080 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] A = new int[R][C];
		for(int i = 0; i < R; i++) {
			String inp = br.readLine();
			for(int j = 0; j < C; j++)
				A[i][j] = inp.charAt(j) - '0';
		}
		
		int[][] B = new int[R][C];
		for(int i = 0; i < R; i++) {
			String inp = br.readLine();
			for(int j = 0; j < C; j++)
				B[i][j] = inp.charAt(j) - '0';
		}
		
		if(R < 3 || C < 3) {
			for(int i = 0; i < R; i++) {
				for(int j = 0; j < C; j++) {
					if(A[i][j] != B[i][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
			System.out.println(0);
			return;
		}
		
		int cnt = 0;
		for(int i = 0; i <= R - 3; i++) {
			for(int j = 0; j <= C - 3; j++) {
				if(A[i][j] == B[i][j]) continue;
				
				convert(A, i, j);
				cnt++;
			}
		}
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(A[i][j] != B[i][j]) {
					System.out.println(-1);
					return;
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	private static int R, C;
	
	private static void convert(int[][] map, int x, int y) {
		for(int i = 0; i < 3; i++) {
			int nx = x + i;
			for(int j = 0; j < 3; j++) {
				int ny = y + j;
				map[nx][ny] = (map[nx][ny] == 0 ? 1 : 0);
			}
		}
	}
}
package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main03085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		sol = -1;
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int nx = i + 1;
				if(nx < N && map[i][j] != map[nx][j]) {
					char a = map[i][j];
					char b = map[nx][j];
					
					map[i][j] = b;
					map[nx][j] = a;
					
					chkMax();
					
					map[i][j] = a;
					map[nx][j] = b;
				}
				
				int ny = j + 1;
				if(ny < N && map[i][j] != map[i][ny]) {
					char a = map[i][j];
					char b = map[i][ny];
					
					map[i][j] = b;
					map[i][ny] = a;
					
					chkMax();
					
					map[i][j] = a;
					map[i][ny] = b;
				}
			}
		}
		
		System.out.println(sol);
	}
	
	private static int N;
	private static char[][] map;
	private static int sol;
	
	private static void chkMax() {
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < N - 1; y++) {
				char candy = map[x][y];
				
				int cnt = 1;
				int idx = y + 1;
				while(idx < N && candy == map[x][idx]) {
					cnt++;
					idx++;
				}
				
				sol = Math.max(sol, cnt);
				y = --idx;
			}
		}
		
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < N - 1; x++) {
				char candy = map[x][y];

				int cnt = 1;
				int idx = x + 1;
				while(idx < N && candy == map[idx][y]) {
					cnt++;
					idx++;
				}
				
				sol = Math.max(sol, cnt);
				x = --idx;
			}
		}
	}
}
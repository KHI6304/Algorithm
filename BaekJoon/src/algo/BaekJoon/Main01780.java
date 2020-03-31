package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main01780 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		sol = new int[3];
		
		solve(0, 0, N);
		
		for(int n : sol)
			System.out.println(n);
	}
	
	private static int N;
	private static int[][] map;
	private static int[] sol;
	
	private static void solve(int sx, int sy, int n) {
		 int data = map[sx][sy];
		 if(n == 1) {
			 if(data == -1) sol[0]++;
			 else if(data == 0) sol[1]++;
			 else sol[2]++;
			 
			 return;
		 }
		 
		int div = n / 3;
		for(int x = sx; x < sx + n; x++) {
			for(int y = sy; y < sy + n; y++) {
				if(map[x][y] != data) {
					for(int i = 0; i < 3; i++)
						for(int j = 0; j < 3; j++)
							solve(sx + i * div, sy + j * div, div);
					return;
				}
			}
		}
		
		if(data == -1) sol[0]++;
		else if(data == 0) sol[1]++;
		else sol[2]++;
	}
}
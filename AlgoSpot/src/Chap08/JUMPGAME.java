package Chap08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JUMPGAME {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			map = new int[n][n];
			memo = new int[n][n];
			
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sol = false;
			jump(0, 0);
			
			if(sol)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

	static boolean sol;
	static int n;
	static int[][] map;
	static int[][] memo;
	
	static void jump(int x, int y) {
		if( sol ) return;
		if( x >= n || y >= n ) return;
		if(y == n - 1 && x == n - 1) { 
			sol = true;
			return;
		}
		
		if(memo[x][y] != 0) return;
		else memo[x][y] = 1;
		
		int jumpSize = map[x][y];
		jump(x + jumpSize, y);
		jump(x, y + jumpSize);
	}
}
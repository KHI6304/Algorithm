package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main02630 {
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
		
		Wcnt = 0; Bcnt = 0;
		
		solve(0, 0, N);
		
		System.out.println(Wcnt);
		System.out.println(Bcnt);
	}
	
	private static int N;
	private static int[][] map;
	private static int Wcnt, Bcnt;
	
	private static void solve(int sx, int sy, int n) {
		int color = map[sx][sy];
		if(n == 1) {
			if(color == 0) Wcnt++;
			else Bcnt++;
			return;
		}
		
		int divN = n / 2;
		for(int x = sx; x < sx + n; x++) {
			for(int y = sy; y < sy + n; y++) {
				if(map[x][y] != color) {
					solve(sx, sy, divN);
					solve(sx + divN, sy, divN);
					solve(sx, sy + divN, divN);
					solve(sx + divN, sy + divN, divN);
					return;
				}
			}
		}
		
		if(color == 0) Wcnt++;
		else Bcnt++;
	}
}
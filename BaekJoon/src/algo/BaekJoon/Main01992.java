package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main01992 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		sol = new StringBuilder();
		
		solve(0, 0, N);
		
		System.out.println(sol.toString());
	}
	
	private static int N;
	private static char[][] map;
	private static StringBuilder sol;
	
	private static void solve(int sx, int sy, int n) {
		char data = map[sx][sy];
		
		if(n == 1) {
			sol.append(data);
			return;
		}
		
		int div = n / 2;
		for(int x = sx; x < sx + n; x++) {
			for(int y = sy; y < sy + n; y++) {
				if(map[x][y] != data) {
					sol.append("(");
					solve(sx, sy, div);
					solve(sx, sy + div, div);
					solve(sx + div, sy, div);
					solve(sx + div, sy + div, div);
					sol.append(")");
					return;
				}
			}
		}
		
		sol.append(data);
	}
}
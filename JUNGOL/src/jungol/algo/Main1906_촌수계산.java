package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main1906_촌수계산 {
	static final int INF = 9999;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n + 1][n + 1];
		for(int i = 1; i <= n; i++)
			Arrays.fill(map[i], INF);
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		int m = Integer.parseInt(br.readLine());
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		for(int mid = 1; mid <= n; mid++) {
			for(int start = 1; start <= n; start++) {
				for(int end = 1; end <= n; end++) {
					if(map[start][end] > map[start][mid] + map[mid][end])
						map[start][end] = map[start][mid] + map[mid][end];
				}
			}
		}
		
		System.out.println(map[x][y] == INF ? -1 : map[x][y]);
	}
}
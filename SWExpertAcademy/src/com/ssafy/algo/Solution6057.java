package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution6057 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[V + 1][V + 1];
			for(int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = map[y][x] = 1;
			}
			
			int sol = 0;
			for(int i = 1; i <= V; i++) {
				for(int j = i; j <= V; j++) {
					if(map[i][j] == 1) {
						for(int k = j; k <= V; k++) {
							if(map[j][k] == 1 && map[i][k] == 1)
								sol++;
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
}
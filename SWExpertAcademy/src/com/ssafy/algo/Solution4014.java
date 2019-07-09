package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution4014 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sol = 0;
			isOk(map, N, X);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int sol;
	static boolean[][] visited;
	
	static void isOk(int[][] map, int N, int X) {
		visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			loop:
			for(int j = 0; j < N - 1; j++) {
				if( map[i][j] - map[i][j + 1] == -1 ) {
					if(j - X + 1 < 0)
						break;
					
					for(int k = 0; k < X; k++) {
						if(visited[i][j - k] || map[i][j] != map[i][j - k]) {
							break loop;
						}
						if(k == X - 1)
							visited[i][j - k] = true;
					}
				}
				else if( map[i][j] - map[i][j + 1] == 1 ) {
					if(j + X >= N)
						break;
					
					for(int k = 0; k < X; k++) {
						if( visited[i][j + k + 1] || map[i][j + 1] != map[i][j + k + 1] ) {
							break loop;
						}
						if(k == X - 1)
							visited[i][j + k + 1] = true;
					}
				}
				else if( Math.abs(map[i][j] - map[i][j + 1]) >= 2 ) {
					break loop;
				}
				
				if(j == N - 2)
					sol++;
			}
		}
		
		visited = new boolean[N][N];
		for(int j = 0; j < N; j++) {
			loop:
			for(int i = 0; i < N - 1; i++) {
				if( map[i][j] - map[i + 1][j] == -1 ) {
					if(i - X + 1 < 0)
						break;
					
					for(int k = 0; k < X; k++) {
						if(visited[i - k][j] || map[i][j] != map[i - k][j]) {
							break loop;
						}
						if(k == X - 1)
							visited[i - k][j] = true;
					}
				}
				else if( map[i][j] - map[i + 1][j] == 1 ) {
					if(i + X >= N)
						break;
					
					for(int k = 0; k < X; k++) {
						if(visited[i + k + 1][j] || map[i + 1][j] != map[i + k + 1][j]) {
							break loop;
						}
						if(k == X - 1)
							visited[i + k + 1][j] = true;
					}
				}
				else if( Math.abs(map[i][j] - map[i + 1][j]) >= 2 ) {
					break loop;
				}
				
				if(i == N - 2)
					sol++;
			}
		}
	}
}
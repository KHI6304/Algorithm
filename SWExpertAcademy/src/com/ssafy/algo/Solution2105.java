package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution2105 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					
				}
			}
		}
	}
	
	// 아래 왼쪽 대각선, 아래 오른쪽 대각선 , 위 오른쪽 대각선, 위 왼쪽 대각선
	static int[] dx = {1, 1, -1, -1};
	static int[] dy = {-1, 1, 1, -1};
	static int N;
	static int[][] map;
	
	static boolean inRange(int nx, int ny) {
		return nx < N && ny < N && nx >= 0 && ny >= 0;
	}
	
	static void dfs(int sx, int sy, int nx, int ny, boolean[][] visited, boolean[] kind, int sum) {
		
	}
}

























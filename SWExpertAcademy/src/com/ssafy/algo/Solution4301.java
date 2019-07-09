package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution4301 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] map = new int[M][N];
			
			int[] dx = {-2, 2, 0, 0};
			int[] dy = {0, 0, -2, 2};
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != -1)
						map[i][j] = 1;
					else
						continue;
					
					for(int d = 0; d < 4; d++) {
						int nx = i + dx[d];
						int ny = j + dy[d];
						
						if(nx < 0 || ny < 0 || nx >= M || ny >= N)
							continue;
						
						map[nx][ny] = -1;
					}
				}
			}
			
			int cnt = 0;
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] == 1)
						cnt++;
				}
			}
			
			System.out.println("#" + tc + " " + cnt);
		}
	}

}
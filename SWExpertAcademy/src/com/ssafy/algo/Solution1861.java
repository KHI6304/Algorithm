package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution1861 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int maxCnt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			
			for(int i = 0 ; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			maxCnt = 0;
			List<Integer> list = new LinkedList<>();
			for(int i = 0 ; i < N; i++) {
				for(int j = 0; j < N; j++) {
					int tmp = 1;
					int x = i;
					int y = j;
					boolean flag = true;
					while(flag) {
						int cnt = 0;
						for(int d = 0; d < dx.length; d++) {
							int nx = x + dx[d];
							int ny = y + dy[d];
						
							if(!inRange(nx, ny))
								continue;
							if(map[nx][ny] - map[x][y] == 1) {
								x = nx;
								y = ny;
								tmp++;
								if(tmp == maxCnt)
									list.add(map[i][j]);
								else if(tmp > maxCnt) {
									list.clear();
									list.add(map[i][j]);
									maxCnt = tmp;
								}
								cnt++;
							}
								
						}
						if(cnt == 0)
							flag = false;
					}
				}
			}
			Collections.sort(list);
			System.out.println("#" + tc + " " + list.get(0) + " " + maxCnt);
		}
	}
	
	
	static boolean inRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}
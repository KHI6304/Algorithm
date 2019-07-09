package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5650 {
	static class Wormhole {
		int x;
		int y;
		int num;
		
		public Wormhole(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine().trim());
			map = new int[N][N];
			Wormhole[] ws = new Wormhole[10];
			int wsize = 0;
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken().trim());
					
					if(map[i][j] >= 6 && map[i][j] <= 10)
						ws[wsize++] = new Wormhole(i, j, map[i][j]);
				}	
			}
			
			int sol = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(map[i][j] != 0)
						continue;
					
					for(int d = 0; d < 4; d++) {
						int tmpCnt = 0;
						int nx = i;
						int ny = j;
						int tmpD = d;
						
						while(true) {
							nx += dx[tmpD];
							ny += dy[tmpD];
							
							// 벽에 부딪힘
							if( !inRange(nx, ny) ) {
								tmpD = reflect(5, tmpD);
								tmpCnt++;
								continue;
							}
							
							// 다시 출발지에 도착
							if(nx == i && ny == j) {
								sol = Math.max(sol, tmpCnt);
								break;
							}
							
							// 블랙홀 만남
							if(map[nx][ny] == -1) {
								sol = Math.max(sol, tmpCnt);
								break;
							}
							
							// 0일떄 그냥 이동
							if(map[nx][ny] == 0)
								continue;
							
							// 웜홀일때
							if(map[nx][ny] >= 6 && map[nx][ny] <= 10) {
								for(int k = 0; k < wsize; k++) {
									if( (ws[k].x != nx || ws[k].y != ny) && ws[k].num == map[nx][ny] ) {
										nx = ws[k].x;
										ny = ws[k].y;
										break;
									}
								}
								continue;
							}
							
							// 블록일때
							tmpD = reflect(map[nx][ny], tmpD);
							tmpCnt++;
						}
					}
					
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int N;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int reflect(int num, int d) {
		switch(num) {
		case 1 :
			if(d == 0)		d = 1;
			else if(d == 1)	d = 3;
			else if(d == 2)	d = 0;
			else if(d == 3)	d = 2;
			break;
		case 2 :
			if(d == 0)		d = 3;
			else if(d == 1)	d = 0;
			else if(d == 2)	d = 1;
			else if(d == 3)	d = 2;
			break;
		case 3 :
			if(d == 0)		d = 2;
			else if(d == 1)	d = 0;
			else if(d == 2)	d = 3;
			else if(d == 3)	d = 1;
			break;
		case 4 :
			if(d == 0)		d = 1;
			else if(d == 1)	d = 2;
			else if(d == 2)	d = 3;
			else if(d == 3)	d = 0;
			break;
		case 5 :
			if(d == 0)		d = 1;
			else if(d == 1)	d = 0;
			else if(d == 2)	d = 3;
			else if(d == 3)	d = 2;
			break;
		}
		return d;
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
}
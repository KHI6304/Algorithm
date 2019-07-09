package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution7250 {
	static class C {
		int x;
		int y;
		int k;	// 종류	1 : 스캇	2 : 악당	3: 불
		int cnt;
		
		public C(int x, int y, int k, int cnt) {
			this.x = x;
			this.y = y;
			this.k = k;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			map = new char[row][col];
			
			q = new LinkedList<>();
			for(int i = 0; i < row; i++) {
				map[i] = br.readLine().toCharArray();
				for(int j = 0; j < col; j++) {
					if(map[i][j] == 'F')
						q.add(new C(i, j, 3, 0));
				}
			}
			for (int i = 0; i < row; i++) {
				for (int j = 0; j < col; j++) {
					if (map[i][j] == 'V')
						q.add(new C(i, j, 2, 0));
				}
			}
			
			for (int i = 0; i < row; i++) {
				for(int j = 0; j < col; j++) {
					if(map[i][j] == 'S')
						q.add(new C(i, j, 1, 0));
				}
			}
			tmpSol = 0;
			sol = Integer.MAX_VALUE;
			
			if(sol == Integer.MAX_VALUE)
				System.out.println(-1);
			else
				System.out.println(sol);
		}
	}
	
	static int[] end;
	static int row;
	static int col;
	static int K;
	static char[][] map;
	static Queue<C> q;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int sol;
	static int tmpSol;
	
	static void BFS() {
		while(!q.isEmpty()) {
			C tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			int k = tmp.k;
			int cnt = tmp.cnt;
			
			if( x == end[0] && y == end[1] ) {
				if(k == 1) {
					if(sol > tmpSol)
						sol = tmpSol;
				}
			}
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!inRange(nx, ny))
					continue;
				
				switch(k) {
				case 3 :	// 불
					if(!FMove(nx, ny))
						break;
					map[nx][ny] = 'F';
					q.add(new C(nx, ny, k, cnt));
					break;
				case 2 :	// 악당
					if(!VMove(nx, ny))
						break;
					q.add(new C(nx, ny, k, cnt));
					break;
				case 1 :	// 스캇
					if(!SMove(nx, ny))
						break;
					
					if(map[nx][ny] == 'A') {
						q.add(new C(nx, ny, k, 0));
					}
					else if( cnt < K && map[nx][ny] == 'W' ) {
						q.add(new C(nx, ny, k, cnt + 1));
					}
					tmpSol++;
					break;
				}	
			}
		}
	}
	
	static boolean SMove(int nx, int ny) {
		if(map[nx][ny] == 'F' || map[nx][ny] == 'X')
			return false;
		
		return true;
	}
	
	static boolean VMove(int nx, int ny) {
		if(map[nx][ny] == 'W' || map[nx][ny] == 'X')
			return false;
		
		return true;
	}
	
	static boolean FMove(int nx, int ny) {
		if(map[nx][ny] == 'W' || map[nx][ny] == 'X')
			return false;
		
		return true;
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < row && ny < col;
	}
}
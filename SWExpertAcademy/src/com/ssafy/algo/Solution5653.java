package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution5653 {
	static class Cell implements Comparable<Cell>{
		int x;
		int y;
		int life;
		int nlife;
		int cnt;
		int t;
		
		public Cell(int x, int y, int life, int nlife, int cnt) {
			this.x = x;
			this.y = y;
			this.life = life;
			this.nlife = nlife;
			this.cnt = cnt;
			t = 0;
		}

		@Override
		public int compareTo(Cell o) {
			return o.life - life;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int size = 0;
			int[][] tmp = new int[N][M];
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					tmp[i][j] = Integer.parseInt(st.nextToken());
					if(tmp[i][j] != 0)
						size++;
				}
			}
			
			Cell[] cs = new Cell[size];
			int idx = 0;
			int[][] map = new int[1000][1000];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					map[i + 500][j + 500] = tmp[i][j];
					if(map[i + 500][j + 500] != 0) {
						cs[idx++] = new Cell(i + 500, j + 500, 
								map[i + 500][j + 500], map[i + 500][j + 500], 0);
					}
				}
			}
			
			Arrays.sort(cs);
			
			cnt = 0;
			q = new LinkedList<>();
			for(int i = 0; i < size; i++)
				q.add(cs[i]);
			
			
		}
	}
	
	static int cnt;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<Cell> q;
	
	static void BFS() {
		while(!q.isEmpty()) {
			Cell tmp = q.poll();
			if(tmp.t == tmp.nlife) {
				
				for(int d = 0; d < 4; d++) {
					
				}
			}
		}
	}
}


























package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5656 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			Col = Integer.parseInt(st.nextToken());
			Row = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[Row][Col];
			
			for(int i = 0; i < Row; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < Col; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			sol = Integer.MAX_VALUE;
			dfs(map, N);
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int N;
	static int Row;
	static int Col;
	static int sol;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	static int getBoomRow(int[][] map, int c) {
		for(int i = 0; i < Row; i++)
			if( map[i][c] != 0 )
				return i;
		return -1;
	}
	
	static int chk(int[][] map) {
		int num = 0;
		for(int i = 0; i < Row; i++) {
			for(int j = 0; j < Col; j++) {
				if(map[i][j] != 0)
					num++;
			}
		}
		return num;
	}
	
	static void dfs(int[][] map, int N) {
		if(N == 0) {
			sol = Math.min(sol, chk(map));
			return;
		}
		
		for(int i = 0; i < Col; i++) {
			int[][] tmp = new int[Row][Col];
			deepCopy(map, tmp);
			crush(tmp, getBoomRow(map, i), i);
			mapClean(tmp);
			dfs(tmp, N - 1);
		}
	}
	
	static void deepCopy(int[][] origin, int[][] clone) {
		for(int i = 0; i < origin.length; i++)
			for(int j = 0; j < origin[i].length; j++)
				clone[i][j] = origin[i][j];
	}
	
	static void crush(int[][] map, int r, int c) {
		if(!inRange(r, c))
			return;
		
		int range = map[r][c];
		map[r][c] = 0;
		
		for(int i = 0; i < range; i++) {
			crush(map, r, c + i);
			crush(map, r, c - i);
			crush(map, r + i, c);
			crush(map, r - i, c);
		}
	}
	
	static void mapClean(int[][] map) {
		for(int j = 0; j < Col; j++) {
			for(int i = Row - 1; i > 0; i--) {
				if(map[i][j] == 0) {
					for(int k = i - 1; k >= 0; k--) {
						if( map[k][j] != 0 ) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
					}
				}
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
}
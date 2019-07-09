package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1227 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= 10; tc++) {
			br.readLine();
			map = new char[100][100];
			for(int i = 0; i < 100; i++)
				map[i] = br.readLine().toCharArray();
			
			bfs();
			if(sol)
				System.out.println("#" + tc + " 1");
			else
				System.out.println("#" + tc + " 0");
		}
	}
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean sol;
	
	static void bfs() {
		Queue<int[]> q = new LinkedList<>();
		visited = new boolean[100][100];
		q.add(new int[] {1, 1});
		visited[1][1] = true;
		sol = false;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(map[nx][ny] == '3') {
					sol = true;
					q.clear();
					break;
				}
				
				if(!visited[nx][ny] && map[nx][ny] == '0') {
					q.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < 100 && ny < 100;
	}
}
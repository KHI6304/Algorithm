package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1949 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][N];
			
			int max = 0;
			Queue<int[]> q = new LinkedList<>();
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] > max) {
						q.clear();
						q.add(new int[] {i, j, 1});
						max = map[i][j];
					}
					else if(map[i][j] == max)
						q.add(new int[] {i, j, 1});
				}
			}
			
			sol = 0;
			for(int i = 0; i < q.size(); i++) {
				int[] tmp = q.poll();
				bfs(map, tmp);
				q.add(tmp);
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					for(int k = 1; k <= K; k++) {
						for(int l = 0; l < q.size(); l++) {
							int[] tmp = q.poll();
							map[i][j] -= k;
							bfs(map, tmp);
							map[i][j] += k;
							q.add(tmp);
						}
					}
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int sol;
	
	static void bfs(int[][] map, int[] start) {
		Queue<int[]> q = new LinkedList<>();
		q.add(start);
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int x = tmp[0];
			int y = tmp[1];
			int cnt = tmp[2];
			int num = map[x][y];
			
			for(int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(!inRange(map, nx, ny))
					continue;
				
				int nnum = map[nx][ny];
				
				if(num > nnum) {
					q.add(new int[] {nx, ny, cnt + 1});
					if(cnt + 1 > sol) {
						sol = Math.max(sol, cnt + 1);
					}
				}
			}
		}
	}
	
	static boolean inRange(int[][] map, int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < map.length && ny < map.length;
	}
}
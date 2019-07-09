package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1953 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			Row = Integer.parseInt(st.nextToken());
			Col = Integer.parseInt(st.nextToken());
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[Row][Col];
			visited = new boolean[Row][Col];
			for(int i = 0; i < Row; i++) { 
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < Col; j++)
					map[i][j] = Integer.parseInt(st.nextToken());
			}
			
			bfs(new int[] {R, C, 1});
			int sol = 0;
			for(int i = 0; i < Row; i++) {
				for(int j = 0; j < Col; j++) {
					if(visited[i][j])
						sol++;
				}
			}
			
			System.out.println("#" + tc + " " + sol);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int Row;
	static int Col;
	static int L;
	static Queue<int[]> q;
	static int[][] map;
	static boolean[][] visited;
	
	static void bfs(int[] start) {
		q = new LinkedList<>();
		q.add(start);
		visited[start[0]][start[1]] = true;
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int cnt = tmp[2];
			
			if(cnt == L)
				continue;
			
			move(tmp);
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < Row && ny < Col;
	}
	
	static void move(int[] p) {
		int nx = p[0];
		int ny = p[1];
		int cnt = p[2];
		
		switch(map[nx][ny]) {
		case 1:
			int tmpX = nx + dx[0];
			int tmpY = ny + dy[0];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 5 || map[tmpX][tmpY] == 6) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[1];
			tmpY = ny + dy[1];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 4 || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[2];
			tmpY = ny + dy[2];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 5) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[3];
			tmpY = ny + dy[3];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 6  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 2:
			tmpX = nx + dx[0];
			tmpY = ny + dy[0];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 5 || map[tmpX][tmpY] == 6) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[1];
			tmpY = ny + dy[1];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 4 || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 3:
			tmpX = nx + dx[2];
			tmpY = ny + dy[2];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 5) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[3];
			tmpY = ny + dy[3];

			if (inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 6  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 4:
			tmpX = nx + dx[0];
			tmpY = ny + dy[0];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 5  || map[tmpX][tmpY] == 6) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1});
			}
			
			tmpX = nx + dx[3];
			tmpY = ny + dy[3];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 6  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 5:
			tmpX = nx + dx[1];
			tmpY = ny + dy[1];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[3];
			tmpY = ny + dy[3];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 6  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 6:
			tmpX = nx + dx[1];
			tmpY = ny + dy[1];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 7) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[2];
			tmpY = ny + dy[2];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 5) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		case 7:
			tmpX = nx + dx[0];
			tmpY = ny + dy[0];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 2 || map[tmpX][tmpY] == 5  || map[tmpX][tmpY] == 6) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			
			tmpX = nx + dx[2];
			tmpY = ny + dy[2];

			if(inRange(tmpX, tmpY) && !visited[tmpX][tmpY] && (map[tmpX][tmpY] == 1 || map[tmpX][tmpY] == 3 || map[tmpX][tmpY] == 4  || map[tmpX][tmpY] == 5) ) {
				visited[tmpX][tmpY] = true;
				q.add(new int[] { tmpX, tmpY, cnt + 1 });
			}
			break;
		}
	}
}
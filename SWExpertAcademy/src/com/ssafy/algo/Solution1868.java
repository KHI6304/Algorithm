package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution1868 {
	// 8방 탐색
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
	static int N;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new char[N][N];
			visited = new boolean[N][N];
			
			for(int i = 0; i < N; i++)
				map[i] = br.readLine().toCharArray();
			
			int clickCnt = 0;
			// bfs 처리  -  시작점이 아직 주어지지 않았다.  ->  반복문을 통해서 여러 지점 가보기
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					// 각 점을 가보자.. 그런데.. 미방문 지점, 지뢰가 아닌 .이어야하고, 주변 8방에 지뢰가 없어야한다.
					if(!visited[i][j] && map[i][j] == '.' && isAroundClear(i, j)) {
						BFS(i, j);	// bfs 한방 = 깔 수 있는 블럭은 까진것.
						clickCnt++;
					}
				}
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] == '.')
						clickCnt++;
				}
			}
			
			sb.append("#" + tc + " " + clickCnt + "\n");
		}
		System.out.print(sb);
	}
	
	static void BFS(int row, int col) {
		Queue<int[]> queue = new LinkedList<>();
		visited[row][col] = true;
		queue.add(new int[] {row, col});
		
		while(!queue.isEmpty()) {
			int[] head = queue.poll();
			// 이 점 주변에 지뢰가 없으면 깔꺼다...
			if(isAroundClear(head[0], head[1])) {
				// 자식 찾기
				for(int i = 0; i < dx.length; i++) {
					int nrow = head[0] + dx[i];
					int ncol = head[1] + dy[i];
					
					// 만약 새로운 지점이 범위에 있고 미방문이고, '.'이라면 방문
					if(inRange(nrow, ncol) && !visited[nrow][ncol] && map[nrow][ncol] == '.') {
						visited[nrow][ncol] = true;
						queue.add(new int[] {nrow, ncol});
					}
				}
			}
		}
	}
	
	// 특정 지점 주변에 지뢰가 있는지 보자!!
	static boolean isAroundClear(int row, int col) {
		boolean res = true;
		for(int d = 0; d < dx.length && res; d++) {
			int nrow = row + dx[d];
			int ncol = col + dy[d];
			
			if(inRange(nrow, ncol) && map[nrow][ncol] == '*')
				return false;
		}
		return res;
	}
	
	static boolean inRange(int row, int col) {
		return row >= 0 && col >= 0 && row < N && col < N;
	}
}
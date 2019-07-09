package com.ssafy.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution1258 {
	static class Matrix implements Comparable<Matrix> {
		int lenRow;
		int lenCol;
		int size;
		
		public Matrix(int lenRow, int lenCol) {
			this.lenRow = lenRow;
			this.lenCol = lenCol;
			this.size = lenRow * lenCol;
		}

		@Override
		public int compareTo(Matrix o) {
			if(size - o.size == 0)
				return lenRow - o.lenRow;
			return size - o.size;
		}

		@Override
		public String toString() {
			return lenRow + " " + lenCol + " ";
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			visited = new boolean[N][N];
			queue = new LinkedList<>();
			
			for(int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			cnt = 1;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(!visited[i][j] && map[i][j] != 0) {
						queue.add(new int[] {i, j});
						BFS();
						cnt++;
					}
				}
			}
			cnt -= 1;
			
			Matrix[] ms = new Matrix[cnt];
			for (int k = 0; k < ms.length; k++) {
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if(map[i][j] == k + 1 ) {
							int tmpX = i;
							int tmpY = j;
							while(inRange(i, tmpY) && map[i][tmpY] != 0) {
								tmpY++;
							}
							tmpY -= 1;
							
							while(inRange(tmpX, j) && map[tmpX][j] != 0) {
								tmpX++;
							}
							tmpX -= 1;
						
							ms[k] = new Matrix(tmpX - i + 1, tmpY - j + 1);
							
							i = tmpX;
							j = tmpY + 1;
						}
					}
				}
			}
			
			Arrays.sort(ms);
			sb.append("#").append(tc).append(" ").append(cnt).append(" ");
			for(Matrix m : ms)
				sb.append(m.toString());
			sb.append("\n");
		}
		System.out.print(sb);
	}
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static Queue<int[]> queue;
	static int cnt;
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	static void BFS() {
		while (!queue.isEmpty()) {
			int[] tmp = queue.poll();
			map[tmp[0]][tmp[1]] = cnt;
			visited[tmp[0]][tmp[1]] = true;
			
			for (int i = 0; i < dx.length; i++) {
				int nx = tmp[0] + dx[i];
				int ny = tmp[1] + dy[i];

				if (!inRange(nx, ny))
					continue;

				if (map[nx][ny] != 0 && !visited[nx][ny]) {
					queue.add(new int[] {nx, ny});
					map[nx][ny] = cnt;
					visited[nx][ny] = true;
				}
			}
		}
	}
}
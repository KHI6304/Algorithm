package jungol.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JNUGOL1462 {
	static class Land {
		int x;
		int y;
		int cnt;
		
		public Land(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		char[][] map = new char[row][col];
		
		for(int i = 0; i < row; i++)
			map[i] = br.readLine().toCharArray();
		
		int maxCnt = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 'L') {
					Queue<Land> queue = new LinkedList<>();
					queue.add(new Land(i, j, 0));
					int cnt;
					boolean[][] visited = new boolean[row][col];
					while(!queue.isEmpty()) {
						Land tmp = queue.poll();
						cnt = tmp.cnt;
						
						for(int direc = 0; direc < 4; direc++) {
							int tmpRow = tmp.x + dx[direc];
							int tmpCol = tmp.y + dy[direc];
							
							if(tmpRow >= map.length || tmpRow < 0 || tmpCol >= map[tmpRow].length || tmpCol < 0)
								continue;
							
							if(map[tmpRow][tmpCol] == 'L' && !visited[tmpRow][tmpCol]) {
								queue.add(new Land(tmpRow, tmpCol, tmp.cnt + 1));
								visited[tmpRow][tmpCol] = true;
								if(maxCnt < tmp.cnt + 1)
									maxCnt = tmp.cnt + 1;
							}	
						}
					}
				}
			}
		}
		
		System.out.println(maxCnt);
	}
}
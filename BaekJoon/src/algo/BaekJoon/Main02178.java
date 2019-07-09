package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02178 {
	static class Position {
		int row;
		int col;
		int cnt;
		
		public Position(int row, int col, int cnt) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i = 0; i < N; i++) {
			String inp = br.readLine();
			for(int j = 0; j < M; j++)
				map[i][j] = inp.charAt(j) - '0';
		}
		
		System.out.println(bfs(map));
	}
	
	// 상, 하, 좌, 우
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static Queue<Position> queue = new LinkedList<>();
	static int sol;
	
	static int bfs(int[][] map) {
		visited[0][0] = true;
		queue.add(new Position(0, 0, 1));
		
		while(!queue.isEmpty()) {
			Position tmp = queue.poll();
			
			if(tmp.row == map.length - 1 && tmp.col == map[tmp.row].length - 1)
				return tmp.cnt;
			
			for(int i = 0; i < 4; i++) {
				int tmpRow = tmp.row + dx[i];
				int tmpCol = tmp.col + dy[i];
				
				if(tmpRow >= map.length || tmpRow < 0 || tmpCol >= map[tmpRow].length || tmpCol < 0)
					continue;
						
				if(map[tmpRow][tmpCol] == 1 && !visited[tmpRow][tmpCol]) {
					visited[tmpRow][tmpCol] = true;
					queue.add(new Position(tmpRow, tmpCol, tmp.cnt + 1));
				}
			}
		}
		return 0;
	}
}
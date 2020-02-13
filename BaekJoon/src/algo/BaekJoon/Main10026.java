package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main10026 {
	private static class Square {
		int x, y;

		public Square(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for(int i = 0; i < N; i++)
			map[i] = br.readLine().toCharArray();
		
		int[] ans = new int[2];
		visited = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(visited[r][c])
					continue;
				
				visited[r][c] = true;
				BFS(new Square(r, c), map[r][c]);
				ans[0]++;
			}
		}
		
		changeColor();
		
		visited = new boolean[N][N];
		for(int r = 0; r < N; r++) {
			for(int c = 0; c < N; c++) {
				if(visited[r][c])
					continue;
				
				visited[r][c] = true;
				BFS(new Square(r, c), map[r][c]);
				ans[1]++;
			}
		}
		
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	private static int N;
	private static char[][] map;
	private static boolean[][] visited;
	
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
	
	private static void changeColor() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				if(map[i][j] == 'G')
					map[i][j] = 'R';
	}
	
	private static void BFS(Square s, char c) {
		Queue<Square> q = new LinkedList<>();
		q.add(s);
		
		while(!q.isEmpty()) {
			Square tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] != c)
					continue;
				
				visited[nx][ny] = true;
				q.add(new Square(nx, ny));
			}
		}
	}
}
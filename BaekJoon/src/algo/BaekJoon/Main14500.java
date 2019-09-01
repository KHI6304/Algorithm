package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main14500 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int R, C;
	static int[][] map;
	static boolean[][] visited;
	static int sol;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		sol = 0;
		map = new int[R + 6][C + 6];
		visited = new boolean[R + 6][C + 6];
		for(int i = 3; i < R + 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 3; j < C + 3; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 3; i < R + 3; i++) {
			for(int j = 3; j < C + 3; j++) {
				visited[i][j] = true;
				solve(i, j, 1, map[i][j]);
				visited[i][j] = false;
				exceptionCase(i, j);
			}
		}
		
		System.out.println(sol);
	}
	
	private static void solve(int x, int y, int depth, int sum) {
		if(depth == 4) {
			sol = Math.max(sol, sum);
			return;
		}
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(visited[nx][ny])
				continue;
			
			visited[nx][ny] = true;
			solve(nx, ny, depth + 1, sum + map[nx][ny]);
			visited[nx][ny] = false;
		}
	}
	
	private static void exceptionCase(int x, int y) {
		int sum = 0;
		
		// 1. ㅗ
		sum += map[x][y];
		sum += map[x - 1][y];
		sum += map[x][y - 1];
		sum += map[x][y + 1];
		sol = Math.max(sol, sum);
		
		// 2. ㅏ
		sum = 0;
		sum += map[x][y];
		sum += map[x - 1][y];
		sum += map[x][y + 1];
		sum += map[x + 1][y];
		sol = Math.max(sol, sum);
		
		// 3. ㅜ
		sum = 0;
		sum += map[x][y];
		sum += map[x][y - 1];
		sum += map[x][y + 1];
		sum += map[x + 1][y];
		sol = Math.max(sol, sum);
		
		// 4. ㅓ
		sum = 0;
		sum += map[x][y];
		sum += map[x - 1][y];
		sum += map[x][y - 1];
		sum += map[x + 1][y];
		sol = Math.max(sol, sum);
	}
}
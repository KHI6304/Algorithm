package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main02667 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			String inp = br.readLine();
			for(int j = 0; j < N; j++)
				map[i][j] = inp.charAt(j) - '0';
		}
		
		int cnt = 0; 
		Queue<int[]> q = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					q.add(new int[] {i, j});
					visited[i][j] = true;
					bfs(map, visited, q, ++cnt);
				}
			}
		}
		
		Collections.sort(list);
		System.out.println(cnt);
		for(int i : list)
			System.out.println(i);
	}
	
	static int N;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static List<Integer> list = new LinkedList<>();
	
	static void bfs(int[][] map, boolean[][] visited, Queue<int[]> q, int cnt) {
		int sol = 1;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				
				if(!inRange(nx, ny))
					continue;
				
				if(!visited[nx][ny] && map[nx][ny]!= 0) {
					visited[nx][ny] = true;
					map[nx][ny] = cnt;
					q.add(new int[] {nx, ny});
					sol++;
				}
			}
		}
		
		list.add(sol);
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < N && ny < N;
	}
}
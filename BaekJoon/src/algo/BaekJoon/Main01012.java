package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main01012 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int col = Integer.parseInt(st.nextToken());
			int row = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			map = new int[row][col];
			visited = new boolean[row][col];
			int sol = 0;
			
			List<int[]> list = new ArrayList<>();
			for(int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int y = Integer.parseInt(st.nextToken());
				int x = Integer.parseInt(st.nextToken());
				list.add(new int[] {x, y});
				
				map[x][y] = 1;
			}
			
			for(int i = 0; i < list.size(); i++) {
				int[] tmp = list.get(i);
				if(visited[tmp[0]][tmp[1]])
					continue;
				sol++;
				BFS(list.get(i));
			}
			
			System.out.println(sol);
		}
	}
	
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] map;
	static boolean[][] visited;
	
	static void BFS(int[] pos) {
		Queue<int[]> q = new LinkedList<>();
		q.add(pos);
		
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			visited[ tmp[0] ][ tmp[1] ] = true;
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp[0] + dx[d];
				int ny = tmp[1] + dy[d];
				
				if(!inRange(nx, ny) || visited[nx][ny] || map[nx][ny] == 0)
					continue;
				
				q.add(new int[] {nx, ny});
				visited[nx][ny] = true;
			}
		}
	}
	
	static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length;
	}
}
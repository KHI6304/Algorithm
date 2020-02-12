package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main03187 {
	private static class Position {
		int x;
		int y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];
		
		for(int i = 0; i < R; i++)
			map[i] = br.readLine().toCharArray();
		
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				
				if(visited[i][j]) continue;
				if(map[i][j] == '#') continue;
				
				BFS(new Position(i, j));
			}
		}
		
		System.out.println(sheepCnt + " " + wolfCnt);
	}
	
	private static char[][] map;
	private static boolean[][] visited;
	private static int[] dx = {-1, 1, 0, 0};
	private static int[] dy = {0, 0, -1, 1};
	private static int sheepCnt = 0;
	private static int wolfCnt = 0;
	
	private static boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length;
	}
	
	private static void BFS(Position p) {
		Queue<Position> q = new LinkedList<>();
		q.add(p);
		
		int sheep = 0;
		int wolf = 0;
		
		visited[p.x][p.y] = true;
		if(map[p.x][p.y] == 'v') wolf++;
		if(map[p.x][p.y] == 'k') sheep++;
		
		while(!q.isEmpty()) {
			Position tmp = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = tmp.x + dx[d];
				int ny = tmp.y + dy[d];
				
				if(!inRange(nx, ny)) continue;
				if(visited[nx][ny] || map[nx][ny] == '#') continue;
				
				visited[nx][ny] = true;
				if(map[nx][ny] == 'v') wolf++;
				if(map[nx][ny] == 'k') sheep++;
				q.add(new Position(nx, ny));
			}
		}
		
		if(sheep > wolf) wolf = 0;
		else sheep = 0;
		
		sheepCnt += sheep;
		wolfCnt += wolf;
	}
}
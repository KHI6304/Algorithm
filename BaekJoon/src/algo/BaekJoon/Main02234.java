package algo.BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main02234 {
	static private class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		c = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		int[][] map = new int[r][c];
		bitMap = new String[r][c];
		visited = new boolean[r][c];
		
		for(int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < c; j++)
				map[i][j] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < r; i++)
			for(int j = 0; j < c; j++)
				bitMap[i][j] = converter(map[i][j]);
		
		for(int i = 0; i < r; i++) {
			for(int j = 0; j < c; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					BFS(new Pos(i, j));
					numOfRoom++;
				}
			}
		}
		
		System.out.println(numOfRoom + " " + maxOfRoom);
	}
	
	static int r, c;
	static String[][] bitMap;
	static boolean[][] visited;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int numOfRoom = 0;
	static int maxOfRoom = 0;
	
	static private String converter(int num) {
		StringBuilder sb = new StringBuilder();
		for(int i = 3; i >= 0; i--) {
			sb.append( (int) (num / Math.pow(2, i)) );
			num %= (int) Math.pow(2, i);
		}
		return sb.toString();
	}
	
	static private void BFS(Pos p) {
		Queue<Pos> q = new LinkedList<>();
		q.add(p);
		int area = 1;
		
		while(!q.isEmpty()) {
			Pos tmp = q.poll();
			int x = tmp.x;
			int y = tmp.y;
			
			for(int d = 0; d < 4; d++) {
				int nx = x + dx[d];
				int ny = y + dy[d];
				
				if(!inRange(nx, ny) || bitMap[x][y].charAt(d) == '1')
					continue;
				
				if(!visited[nx][ny]) {
					q.add(new Pos(nx, ny));
					visited[nx][ny] = true;
					area++;
				}
			}
		}
		
		maxOfRoom = Math.max(maxOfRoom, area);
	}
	
	static private boolean inRange(int nx, int ny) {
		return nx >= 0 && ny >= 0 && nx < r && ny < c;
	}
}